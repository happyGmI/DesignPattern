package com.xidian.designpattern01.chain.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Class: UserDto
 * @Author: Wei Junwei
 * @Time: 2022/9/13 21:42
 * @Description:
 */
@Data
@Builder
public class UserDto {
    private String userName;
    private String password;
    private Integer permission;
    private Integer accessLevel;
}
