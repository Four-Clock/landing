package com.myself.mybatis.plugins;

import com.myself.logger.LoggerUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

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
        args = {MappedStatement.class,Object.class})})
public class ConsumerPlugin implements Interceptor {
    private static final String PLUGIN_NAME_KEY = "pluginName";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        LoggerUtil.info(properties.getProperty(PLUGIN_NAME_KEY));
        Object returnObject = invocation.proceed();
        return returnObject;
    }

    private Properties properties = new Properties();

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
