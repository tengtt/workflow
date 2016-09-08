package org.seckill.study.mybatis;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Created by teng on 2016/6/1.
 *
 * 分页拦截器
 */
@Intercepts(@Signature(type= StatementHandler.class,method = "prepare",args = {Connection.class}))
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
        MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");

        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();
            //原始sql
            String sql = boundSql.getSql();
            //查询总条数的SQL语句
            String countSql = "select count(*) from ("+ sql + ") a";
            Connection connection = (Connection)invocation.getArgs()[0];
            connection.prepareStatement(countSql);
            Map<String,Object> parameter = (Map<String,Object>)boundSql.getParameterObject();
            Page page = (Page)parameter.get("page");
            String pageSql = sql + " limit " + page.getDbIndex() +","+page.getDbNumber();
            //修改之前的sql为分页之后的sql
            metaObject.setValue("delegate.boundSql.sql",pageSql);
        }
        return null;
    }

    @Override
    public Object plugin(Object target) {
        Plugin.wrap(target,this);
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
