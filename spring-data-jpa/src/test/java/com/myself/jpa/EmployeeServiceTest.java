package com.myself.jpa;

import cm.myself.jpa.Starter;
import cm.myself.jpa.dto.EmployeeDTO;
import cm.myself.jpa.service.EmployeeService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myself.logger.LoggerUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 功能描述: EmployeeServiceTest
 *
 * @author linqin.zxl
 * @date 2021/4/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testFindEmployeeById(){
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(13);
        LoggerUtil.info(JSONObject.toJSONString(employeeDTO));
    }

    @Test
    public void testAddEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setLastName("张三");
        employeeDTO.setGender("1");
        employeeDTO.setEmail("456@qq.com");
        employeeDTO.setDeptNo("2");
        Integer ret = employeeService.addEmployee(employeeDTO);
        Assert.assertTrue(ret>0);
    }

    @Test
    public void testUpdateEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setLastName("张三");
        employeeDTO.setGender("男");
        employeeDTO.setEmail("456@qq.com");
        employeeDTO.setDeptNo("2");
        employeeDTO.setId("22");
        Integer ret = employeeService.updateEmployee(employeeDTO);
        Assert.assertTrue(ret>0);
    }

    @Test
    public void testDeleteEmployeeById(){
        Boolean btn = employeeService.deleteEmployeeById(13);
        Assert.assertTrue(btn);
    }

    @Test
    public void testFindEmployees(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender("男");
        List<EmployeeDTO> employees = employeeService.findEmployees(employeeDTO);
        LoggerUtil.info(JSON.toJSONString(employees));
    }
}
