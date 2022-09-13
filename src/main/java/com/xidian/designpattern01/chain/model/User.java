package com.xidian.designpattern01.chain.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class: User
 * @Author: Wei Junwei
 * @Time: 2022/9/13 21:39
 * @Description:
 */
@Data
@Builder
public class User {
    public static Map<String, User> userMap = new HashMap<>(16);
    static {
        User weiJunwei = new User("Wei Junwei", "123456", 1);
        User wuYue = new User("Wu Yue", "123456", 2);
        userMap.put("Wei Junwei", weiJunwei);
        userMap.put("Wu Yue", wuYue);
    }

    private String userName;
    private String password;
    private Integer permission;
}
