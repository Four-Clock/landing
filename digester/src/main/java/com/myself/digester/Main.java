package com.myself.digester;

import com.myself.digester.entity.Host;
import com.myself.digester.entity.Server;
import com.myself.logger.LoggerUtil;
import org.apache.commons.digester3.Digester;

import java.io.InputStream;

/**
 * 功能描述: Main
 * Digester 解析xml文件
 * @author linqin.zxl
 * @date 2021/5/14
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("server", Server.class);
        digester.addSetProperties( "server" );

        digester.addObjectCreate("server/host", Host.class);
        digester.addSetProperties("server/host");
        digester.addSetNext("server/host","setHost");
        InputStream xmlResource = Thread.currentThread().getContextClassLoader().getResourceAsStream("server.xml");
        Server server = digester.parse(xmlResource);
        LoggerUtil.info(server.toString());

    }
}
