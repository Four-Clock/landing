package com.myself.springboot.bean;

import com.myself.logger.LoggerUtil;
import lombok.Data;

/**
 * 功能描述: Father
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@Data
public class Brother {
    private String name;
    private String[] hobby;

    public void init(){
        LoggerUtil.info("init method invoke name:"+name+" hobby:"+String.join("|",hobby));
    }
}
