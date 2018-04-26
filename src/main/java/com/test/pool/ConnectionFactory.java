package com.test.pool;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author huangchangling on 2017/12/14 0014
 */
public class ConnectionFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);
    private static BeanContainer container = BeanContainer.getInstance();

    public static Connection getConn(String dataSourceName){

        if(StringUtils.isNotEmpty(dataSourceName)) {
            try {
                return ((BasicDataSource) container.singletonMap.get(dataSourceName)).getConnection();
            } catch (SQLException e) {
                LOGGER.error("getConn>>Exception", e);
            }
        }
        return null;
    }
    public static void close(Connection conn) throws SQLException {
        if(conn !=null){
            conn.close();
        }
    }
}
