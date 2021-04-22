package com.myself.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述: LoggerUtil
 *  Logback 工具类
 * @author linqin.zxl
 * @date 2021/4/22
 */
public class LoggerUtil {
    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(LoggerUtil.class);
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void error(String errMsg,Exception... exceptions){
        logger.error(errMsg,exceptions);
    }


    public static void debug(String message){
        logger.debug(message);
    }

    public static void warn(String message){
        logger.warn(message);
    }

}
