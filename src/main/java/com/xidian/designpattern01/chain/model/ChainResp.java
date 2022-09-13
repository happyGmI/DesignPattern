package com.xidian.designpattern01.chain.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Class: ChainResp
 * @Author: Wei Junwei
 * @Time: 2022/9/13 23:40
 * @Description:
 */
@Data
@Builder
public class ChainResp {
    private int level;
    private boolean result;
    private String message;
}
