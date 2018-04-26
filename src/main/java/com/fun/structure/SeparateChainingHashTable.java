package com.fun.structure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangchangling on 2017/9/13 0013
 * @description 分离链接散列表的类结构
 */
public class SeparateChainingHashTable<AnyType> {

    public SeparateChainingHashTable(){this(DEFAULT_TABLE_SIZE);}

    public SeparateChainingHashTable(int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i=0;i<theLists.length;i++) theLists[i] = new LinkedList<>();
    }

    /**
     * make the hash table logically empty
     */
    public void makeEmpty(){
        for(int i=0;i<theLists.length;i++)
            theLists[i].clear();
        currentSize = 0;
    }

    /**
     * insert into the hash table
     * @param x
     */
    public void insert(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if(!whichList.contains(x)){
            whichList.add(x);
            if(++currentSize > theLists.length)
                rehash();
        }
    }

    /**
     * remove from the hash table
     * @param x
     */
    public void remove(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if(whichList.contains(x)){
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * find an item in the hash table
     * @param x
     * @return
     */
    public boolean contains(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    private static final int DEFAULT_TABLE_SIZE =101;

    private List<AnyType>[] theLists;

    private int currentSize;

    private void rehash(){}

    private int myhash(AnyType x){
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if(hashVal < 0) hashVal += theLists.length;
        return hashVal;
    }

    private static int nextPrime(int n){return 0;}

    private static boolean isPrime(int n){return false;}


}
