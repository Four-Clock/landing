package com.myself.jpa;

import cm.myself.jpa.Starter;
import cm.myself.jpa.service.DeptService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    public void testFindDeptById(){
        deptService.findDeptById(1);
    }

}
