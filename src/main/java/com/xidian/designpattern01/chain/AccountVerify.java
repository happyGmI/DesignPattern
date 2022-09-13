package com.xidian.designpattern01.chain;

import com.xidian.designpattern01.chain.model.ChainResp;
import com.xidian.designpattern01.chain.model.User;
import com.xidian.designpattern01.chain.model.UserDto;
import org.apache.commons.lang3.StringUtils;

/**
 * @Class: AccountVerify
 * @Author: Wei Junwei
 * @Time: 2022/9/13 21:32
 * @Description:
 */
public class AccountVerify extends AbstractVerify{
    @Override
    protected ChainResp verify(UserDto userDto) {
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        if (!User.userMap.containsKey(userName)) {
            return ChainResp.builder()
                    .level(this.level)
                    .result(false)
                    .message("用户验证不通过！")
                    .build();
        } else if (StringUtils.endsWithAny(User.userMap.get(userName).getPassword(), password)) {
            return ChainResp.builder()
                    .result(true)
                    .build();
        } else {
            return ChainResp.builder()
                    .level(this.level)
                    .result(false)
                    .message("用户验证不通过！")
                    .build();
        }
    }
}
