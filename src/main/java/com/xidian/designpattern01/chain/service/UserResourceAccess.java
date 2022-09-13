package com.xidian.designpattern01.chain.service;

import com.xidian.designpattern01.chain.AccountVerify;
import com.xidian.designpattern01.chain.constants.VerifyConstant;
import com.xidian.designpattern01.chain.model.User;
import com.xidian.designpattern01.chain.model.UserDto;
import com.xidian.designpattern01.chain.model.UserResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: UserResourceAccess
 * @Author: Wei Junwei
 * @Time: 2022/9/13 22:00
 * @Description:
 */
@Slf4j
@Service
public class UserResourceAccess {

    @Autowired
    AccountVerify accountVerify;

    public UserResp resourceAccess(UserDto userDto) throws Exception {
        return UserResp.builder()
                .message(accountVerify.continueVerity(VerifyConstant.PERMISSION_VERITY, userDto).getMessage())
                .build();
    }
//    public static void main(String[] args) {
//        try {
//            UserResourceAccess.resourceAccess(
//                    UserDto.builder()
//                            .userName("Wei Jun")
//                            .password("123456")
//                            .accessLevel(4)
//                            .permission(1)
//                            .build()
//            );
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
}
