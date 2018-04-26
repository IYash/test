package com.netty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * @author huangchangling on 2017/8/29 0029
 * 编码性能测试
 */
public class PerformTestUserInfo {

    public static void main(String[] args) throws IOException {

        UserInfo info = new UserInfo();
        info.buildUserName("Welcome to Netty").buildUserID(100);
        int loop = 1000000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long startTime = System.currentTimeMillis();
        for(int i=0;i<loop;i++){
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The jdk serializable cost time is:" +(endTime-startTime)+" ms");

        System.out.println("------------------");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i=0;i<loop;i++){
            byte[] b = info.codeC(buffer);
        }
        endTime = System.currentTimeMillis();

        System.out.println("The byte array serializable cost time is:" +(endTime-startTime)+" ms");
    }
}
