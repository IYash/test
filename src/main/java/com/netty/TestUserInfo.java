package com.netty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author huangchangling on 2017/8/29 0029
 *
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserName("Welcome to Netty").buildUserID(100);
        /**
         * java提供的对象输入/输出流ObjectInputStream和ObjectOutputStream，可以
         * 把java对象作为可存储的字节数组写入文件，也可以传输到网络上
         */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(info);
        os.flush();
        os.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serializable length is:" + b.length);
        bos.close();
        System.out.println("--------------------");
        System.out.println("The byte array serializable length is:" +info.codeC().length);
    }
}
