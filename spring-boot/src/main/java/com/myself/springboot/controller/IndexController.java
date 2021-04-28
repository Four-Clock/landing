package com.myself.springboot.controller;

import com.myself.response.BaseResult;
import com.myself.response.BaseResultUtils;
import com.myself.springboot.anno.Permission;
import com.myself.springboot.dto.DeptDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述: IndexController
 *
 * @author linqin.zxl
 * @date 2021/4/28
 */

@RestController
@RequestMapping("/springboot")
public class IndexController {

    @RequestMapping("/index")
    @Permission
    public BaseResult index(List<DeptDto> deptList){
        return BaseResultUtils.success(deptList);
    }


    /**
     * @ModelAttribute name值来源于getName
     * @param name
     * @return
     */
    @RequestMapping("/hello")
    public BaseResult hello(@ModelAttribute(name = "name")String name){
        return BaseResultUtils.success(name);
    }

    @ModelAttribute("name")
    public String getName(){
        return "李四";
    }

}
