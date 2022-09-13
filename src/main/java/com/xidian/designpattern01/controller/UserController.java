package com.xidian.designpattern01.controller;

import com.xidian.designpattern01.chain.model.UserDto;
import com.xidian.designpattern01.chain.model.UserResp;
import com.xidian.designpattern01.chain.service.UserLoginAccess;
import com.xidian.designpattern01.chain.service.UserResourceAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: UserController
 * @Author: Wei Junwei
 * @Time: 2022/9/13 22:45
 * @Description:
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    UserLoginAccess userLoginAccess;
    @Autowired
    UserResourceAccess userResourceAccess;

    @GetMapping("/user/log/in")
    public UserResp login() {
        UserResp resp = null;
        try {
             resp = userLoginAccess.login(
                    UserDto.builder()
                            .userName("Wei Junwei")
                            .password("12356")
                            .accessLevel(4)
                            .permission(1)
                            .build()
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return resp;
    }
    @GetMapping("/user/resource/access")
    public UserResp resourceAccess() {
        UserResp resp = null;
        try {
            resp = userResourceAccess.resourceAccess(
                    UserDto.builder()
                            .userName("Wei Junwei")
                            .password("123456")
                            .accessLevel(4)
                            .permission(1)
                            .build()
            );
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return resp;
    }
}
