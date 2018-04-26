package com.fun.structure;

/**
 * @author huangchangling on 2017/9/13 0013
 */
public class HashExample {

    /**
     * hash函数的一种实现，利用字符的hashCode求和
     */
    public static int hash(String key,int tableSize){
        int hashVal = 0;
        for(int i=0;i<key.length();i++)
            hashVal += key.charAt(i);

        return hashVal % tableSize;
    }

    /**
     * hash route a string
     * @param key
     * @param tableSize
     * @return
     */
    public static int hashRoute(String key,int tableSize){
        int hashVal = 0;
        for(int i=0;i<key.length();i++)
            hashVal = 37*hashVal + key.charAt(i);
        hashVal %=tableSize;
        if(hashVal < 0) hashVal += tableSize;
        return hashVal;
    }

}
