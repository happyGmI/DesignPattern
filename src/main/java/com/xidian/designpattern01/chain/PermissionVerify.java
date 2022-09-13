package com.xidian.designpattern01.chain;

import com.xidian.designpattern01.chain.model.ChainResp;
import com.xidian.designpattern01.chain.model.UserDto;

/**
 * @Class: PermissionVerify
 * @Author: Wei Junwei
 * @Time: 2022/9/13 21:33
 * @Description:
 */
public class PermissionVerify extends AbstractVerify {
    @Override
    protected ChainResp verify(UserDto userDto) {
        if (userDto.getPermission() >= userDto.getAccessLevel()) {
            System.out.println("用户有权限访问当前资源！");
            return ChainResp.builder()
                    .result(true)
                    .build();
        }
        System.out.println("用户没有权限访问当前资源！");
        return ChainResp.builder()
                .result(false)
                .level(this.level)
                .message("用户没有权限访问当前资源！")
                .build();
    }
}
