package com.func.exercise;

import com.fun.BinaryHeap;
import com.fun.MyArrayUtil;
import org.junit.Test;

/**
 * @author huangchangling on 2017/9/4 0004
 * @Description 第一章练习
 */
public class CapOneExercise {

    /**
     * 选择问题，令K=N/2,找出第K大（小）的数;
     */
   @Test
    public void testQ1(){
       int[] src = MyArrayUtil.getSrc(10,200);
       MyArrayUtil.printArr(src);
       int len = src.length;
       int k = len/2;
       MyArrayUtil.quickSort(src,0,k-1);//升序排序
       System.out.println("k------------------------------"+k);
       //MyArrayUtil.printArr(src);
       //使用插入排序的方式找出第K大（小）的数
       for(int j= k;j<len;j++){
            insert(src,k,j);
       }
       System.out.println("result-------------------------"+src[k-1]);
       MyArrayUtil.printArr(src);
   }
    private void insert(int[] src,int k,int x){
        //保持原有数组的数据
        int temp = src[x];
        for(int i=0;i<k;i++){
            if(temp < src[i]){//保留小的数
                int out = src[k-1];
               for(int j=k-1;j>i;j--){
                   src[j] = src[j-1];
               }
               src[i]=temp;
                src[x]=out;
                break;
            }
        }
    }
}
