package com.myself.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述: SexTypeHandler
 * 自定义类型转换器
 * 数据库gender 字段未0->男，1->女，other->N
 * 配置参考
 * @see mapper/EmployeeMapper.xml
 * @author linqin.zxl
 * @date 2021/4/22
 */
@MappedJdbcTypes(JdbcType.CHAR)
public class SexTypeHandler extends BaseTypeHandler<Character> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Character character, JdbcType jdbcType) throws SQLException {
        setNonNullParameter(preparedStatement,i,character,jdbcType);
    }

    @Override
    public Character getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String val = resultSet.getString(s);
        if ("0".equals(val)){
            return Character.valueOf('男');
        }
        if ("1".equals(val)){
            return '女';
        }
        return 'N';
    }

    @Override
    public Character getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getNullableResult(resultSet,i);
    }

    @Override
    public Character getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getNullableResult(callableStatement,i);
    }
}
