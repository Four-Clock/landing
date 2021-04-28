package com.myself.jpa;

import cm.myself.jpa.Starter;
import cm.myself.jpa.dto.DeptDTO;
import cm.myself.jpa.dto.EmployeeDTO;
import cm.myself.jpa.service.DeptService;
import com.alibaba.fastjson.JSON;
import com.myself.logger.LoggerUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * 功能描述: DeptServiceTest
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class DeptServiceTest {

    @Resource
    private DeptService deptService;

    @Test
    public void testFindDeptById(){
       LoggerUtil.info(JSON.toJSONString( deptService.findDeptById(1)));
    }

    @Test
    public void testInsertSingleDept(){
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setDeptName("this is a test");
        deptDTO.setDeptDesc("this is a test description");
        deptDTO.setCreateTime(new Date());
        deptDTO.setDeptNo(1);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setGender("1");
        employeeDTO.setEmail("136@qq.com");
        employeeDTO.setDeptNo("1");
        employeeDTO.setLastName("mike");
        deptDTO.setEmployeeDTO(new ArrayList<>());
        deptDTO.getEmployeeDTO().add(employeeDTO);
        Boolean aBoolean = deptService.insertSingleDept(deptDTO);
        LoggerUtil.info("insert result is :"+aBoolean);
    }

}
