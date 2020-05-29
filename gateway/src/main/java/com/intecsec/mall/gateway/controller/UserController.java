package com.intecsec.mall.gateway.controller;

import com.intecsec.mall.common.utils.RestResponse;
import com.intecsec.mall.gateway.service.UserService;
import com.intecsec.mall.user.dto.UserConsigneeDTO;
import com.intecsec.mall.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-01-10 09:58
 **/
@RestController()
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    @ResponseBody
    public String get(@PathVariable Long userId) {
        return RestResponse.success(userService.getUser(userId));
    }

    @ResponseBody
    @GetMapping("/list")
    public Object list(@RequestParam(name = "page_num", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "page_size", required = false, defaultValue = "20") int pageSize) {
        return RestResponse.success(userService.getUserList(pageNum, pageSize));
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public Object update(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        int result = userService.update(userId, userDTO);
        return RestResponse.success(result);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Long userId) {
        int result = userService.delete(userId);
        return RestResponse.success(result);
    }

    @RequestMapping(value = "/consigee/{id}", method = RequestMethod.GET)
    public UserConsigneeDTO getUserConsignee(@PathVariable Long id) {
        UserConsigneeDTO userConsigneeDTO = userService.getUserConsignee(id);
        return userConsigneeDTO;
    }

}
