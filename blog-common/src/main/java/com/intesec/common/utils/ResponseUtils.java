package com.intesec.common.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intesec.common.Enums.ResponseEnum;
import com.intesec.common.Response.ApiResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 控制器输出类
 * @author: peter.peng
 * @create: 2018-11-02 10:51
 **/
public class ResponseUtils {

    /**
     * 处理下划线分割的json字符串（生成json字符串时候将驼峰转化为下划线，解析json时候将下划线转为驼峰）
     */
    private static Gson gson;

    private final static String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    private final static DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_STR);

    static{
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.disableHtmlEscaping();//禁止html转义
        gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    /**
     * 使用Gson生成json字符串
     * @param src
     * @return
     */
    public static String toJsonStr(Object src){
        return gson.toJson(src);
    }

    public static String getSuccessApiResponseStr(Object module){
        ApiResponse apiResponse = new ApiResponse(ResponseEnum.REQUEST_SUCESS);
        apiResponse.setData(module);
        return toJsonStr(apiResponse);
    }

    public static String getFailApiResponseStr(ResponseEnum responseEnum, String message){
        ApiResponse apiResponse = new ApiResponse(responseEnum.getCode(), message);
        return toJsonStr(apiResponse);
    }

    /**
     *  返回特定错误的json串
     */
    public static String getFailApiResponseStr(int code, String message){
        ApiResponse apiResponse = new ApiResponse(code, message);
        return toJsonStr(apiResponse);
    }

    /**
     * 返回特定的时间格式
     * @param date
     * @param format 1 2 区分后续扩展其他的类型
     * @return
     */
    public static String toFormatDate(Date date, int format){
        if(date == null){
            return null;
        }
        switch(format) {
            case 1:
                return DATE_FORMAT.format(date);
            default:
                return DATE_FORMAT.format(date);
        }
    }
}
