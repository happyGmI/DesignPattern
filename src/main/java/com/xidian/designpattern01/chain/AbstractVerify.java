package com.xidian.designpattern01.chain;

import com.xidian.designpattern01.chain.model.ChainResp;
import com.xidian.designpattern01.chain.model.UserDto;
import org.apache.commons.lang3.StringUtils;

/**
 * @Class: AbstractVerify
 * @Author: Wei Junwei
 * @Time: 2022/9/13 21:32
 * @Description: 资源访问验证责任链 AccountVerity ---> PermissionVerity
 */
public abstract class AbstractVerify {

    protected int level;
    private AbstractVerify nextVerity;

    public void setLevel(int level) {
        this.level = level;
    }
    public void setNextVerity(AbstractVerify nextVerity){
        this.nextVerity = nextVerity;
    }
    public ChainResp continueVerity(int level, UserDto userDto) throws Exception {
        if(this.level <= level){
            ChainResp resp = verify(userDto);
            if (!resp.isResult() && StringUtils.isNotEmpty(resp.getMessage())) {
                return resp;
            }
        }
        if(nextVerity != null){
            nextVerity.continueVerity(level, userDto);
        }
        return ChainResp
                .builder()
                .result(true)
                .message("验证通过！")
                .build();
    }
    /**
     * 验证用户是否具有访问对应资源的权限
     * @param userDto
     * @return
     * @throws Exception
     */
    abstract protected ChainResp verify(UserDto userDto) throws Exception;
}
