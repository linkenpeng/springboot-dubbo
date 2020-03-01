package com.intecsec.mall.gateway.interceptor;

import com.intecsec.mall.common.Enums.ResponseEnum;
import com.intecsec.mall.common.utils.IpUtils;
import com.intecsec.mall.common.utils.JsonUtils;
import com.intecsec.mall.common.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 接口权限认证
 * @author: peter.peng
 * @create: 2020-03-01 21:06
 **/
@Slf4j
public class PermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean pass = validateSign(request);
        if (pass) {
            return true;
        } else {
            log.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}",
                    request.getRequestURI(), IpUtils.getIpAddress(request), JsonUtils.toJson(request.getParameterMap()));
            responseResult(response, RestResponse.fail(ResponseEnum.UNAUTHORIZED));
            return false;
        }
    }

    private void responseResult(HttpServletResponse response, String jsonResult) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(jsonResult);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    private boolean validateSign(HttpServletRequest request) {
        String requestSign = request.getParameter("sign");
        if (StringUtils.isEmpty(requestSign)) {
            return false;
        }
        List<String> keys = new ArrayList<>(request.getParameterMap().keySet());
        keys.remove("sign");
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append("=").append(request.getParameter(key)).append("&");
        }
        String linkString = sb.toString();
        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);

        // TODO 采用自定义的密钥
        String secret = "Potato";
        String sign = DigestUtils.md5Hex(linkString + secret);

        log.info("sign:{}, requestSign:{}", sign, request);
        return StringUtils.equals(sign, requestSign);
    }
}
