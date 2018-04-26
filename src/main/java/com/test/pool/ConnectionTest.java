package com.test.pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author huangchangling on 2017/12/14 0014
 */
public class ConnectionTest {

    public static void main(String[] args) throws InterruptedException, SQLException {
        for (int i=0;i<400;i++){
            Connection conn= ConnectionFactory.getConn("test");
            //Thread.currentThread().sleep(1000);
            System.out.println(i+"-------------------------------------");
            ConnectionFactory.close(conn);

        }
        System.out.println("done==================================");
    }
}
