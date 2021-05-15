package com.myself.digester;

import com.myself.logger.LoggerUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import ognl.AbstractMemberAccess;
import ognl.Ognl;
import ognl.OgnlContext;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * 功能描述: OgnlMain
 * ognl 表达式应用
 * 1：如果是根元素，expression 可直接取值 如：Ognl.getValue("age", ognlContext, user);
 * 2：如果为非根元素，expression 通过# 取值，如:Ognl.getValue("#user.name", ognlContext, root);
 * @author linqin.zxl
 * @date 2021/5/14
 */
public class OgnlMain {

    public static void main(String[] args) throws Throwable {

        OgnlContext ognlContext = new OgnlContext(null,null, new AbstractMemberAccess() {
            @Override
            public boolean isAccessible(Map map, Object o, Member member, String s) {
                int modifiers = member.getModifiers();
                return Modifier.isPublic(modifiers);
            }
        });
        String root = "root";
        ognlContext.put("root",root);
        ognlContext.put("parent","张二");
        User user = new User("张三","男",26);
        ognlContext.put("user",user);
        Object age = Ognl.getValue("#user.age", ognlContext, user);
        Object name = Ognl.getValue("#user.name", ognlContext, user);
        Object sex = Ognl.getValue("#user.sex", ognlContext, user);
        LoggerUtil.info("姓名:"+name+" 年龄："+age+" 岁"+" 性别:"+sex);
    }

    @Data
    @AllArgsConstructor
    public static class User{
        private String name;
        private String sex;
        private Integer age;
    }
}
