package com.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author huangchangling on 2017/8/22 0022
 */
public class ByteBufferTest {

    @Test
    public void testBuffer(){
        ByteBuffer buffer = ByteBuffer.allocate(88);
        String value = "Netty权威指南";
        buffer.put(value.getBytes());
        buffer.flip();
        int cap = buffer.remaining();
        //byte[] vArray = new byte[10];
        byte[] vArray = new byte[8];
        buffer.get(vArray);
        String decodeValue = new String(vArray);
        byte[] nvArray = new byte[9];
        buffer.get(nvArray);
        String ndecodeValue = new String(nvArray);
        System.out.println(cap + "---->"+decodeValue + "---->"+ ndecodeValue);
    }
}
