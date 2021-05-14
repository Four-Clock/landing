package com.myself.digester.entity;

import lombok.Data;
import lombok.ToString;

/**
 * 功能描述: Server
 *
 * @author linqin.zxl
 * @date 2021/5/14
 */
@Data
@ToString
public class Server {

    private String name;
    private String author;

    private Host host;

}
