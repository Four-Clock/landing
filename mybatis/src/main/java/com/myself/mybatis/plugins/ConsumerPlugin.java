package com.myself.mybatis.plugins;

import com.myself.logger.LoggerUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * 功能描述: ConsumerPlugin
 * 自定义插件实现拦截方法的调用
 * 具体拦截方法可查看如下
 * Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 * @author linqin.zxl
 * @date 2021/4/22
 */
@Intercepts({@Signature(
        type= Executor.class,
        method = "update",
        args = {MappedStatement.class,Object.class}),
        @Signature(
                type= Executor.class,
                method = "query",
                args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class ConsumerPlugin implements Interceptor {

    private static final String PLUGIN_NAME_KEY = "pluginName";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        LoggerUtil.info(properties.getProperty(PLUGIN_NAME_KEY));
        Object returnObject = invocation.proceed();

        if (Objects.isNull(returnObject)){
            return null;
        }
        if (checkNormalType(returnObject)){
            LoggerUtil.info(String.valueOf(returnObject));
        }
        if (List.class.isAssignableFrom(returnObject.getClass())){
            StringJoiner joiner = new StringJoiner("\n");
            for (Object o : ((List) returnObject)) {
                joiner.add(o.toString());
            }
            if (joiner.length()>0){
                LoggerUtil.info(joiner.toString());
            }
            return returnObject;
        }
        return returnObject;
    }

    private Properties properties = new Properties();

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private boolean checkNormalType(Object type){
        if (Integer.class.isAssignableFrom(type.getClass())
            || String.class.isAssignableFrom(type.getClass())
            || Double.class.isAssignableFrom(type.getClass())
            || Float.class.isAssignableFrom(type.getClass())
            || Character.class.isAssignableFrom(type.getClass())){
            return true;
        }
        return false;
    }
}
