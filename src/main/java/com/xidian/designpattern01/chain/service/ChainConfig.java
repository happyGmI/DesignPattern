package com.xidian.designpattern01.chain.service;

import com.xidian.designpattern01.chain.AccountVerify;
import com.xidian.designpattern01.chain.PermissionVerify;
import com.xidian.designpattern01.chain.constants.VerifyConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class: ChainConfig
 * @Author: Wei Junwei
 * @Time: 2022/9/13 22:35
 * @Description:
 */
@Configuration
public class ChainConfig {

    @Bean
    public PermissionVerify permissionVerify() {
        PermissionVerify permissionVerify = new PermissionVerify();
        permissionVerify.setLevel(VerifyConstant.PERMISSION_VERITY);
        permissionVerify.setNextVerity(null);
        return permissionVerify;
    }

    @Bean
    public AccountVerify accountVerify(PermissionVerify permissionVerify) {
        AccountVerify accountVerify = new AccountVerify();
        permissionVerify.setLevel(VerifyConstant.ACCOUNT_VERITY);
        accountVerify.setNextVerity(permissionVerify);
        return accountVerify;
    }
}
