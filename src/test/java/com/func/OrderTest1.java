package com.func;

import org.junit.Test;

import java.util.Random;

/**
 * @author huangchangling on 2017/9/4 0004
 */
public class OrderTest1 {
    @Test
    public void testCycle() {
        int[] src = getSrc(8, 100);
        //src = new int[]{65,60,20,63,51,69,45,89};//{29,39,42,40,48,17,34,29,67,10}; //
        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
        System.out.println("====================");
        quickSorty(src, 0, src.length - 1);
        //quickSort(src,0,src.length-1);
        print(src);
    }

    int[] getSrc(int num, int range) {
        int[] ret = new int[num];
        for (int i = 0; i < num; i++) {
            ret[i] = new Random().nextInt(range);
        }
        return ret;
    }
    void print(int[] src){
        for (int i = 0; i < src.length; i++) {
            System.out.println(src[i]);
        }
        System.out.println("------------------===============");
    }
    void quickSorty(int[] src,int left,int right){
        if(left>=right) {System.out.println(left+"-------++++++++++"+right);return;}
        int index = quickSort(src,left,right);
        //print(src);System.out.println("first===================");
        quickSorty(src,left,index-1);
        //print(src);System.out.println("second=================");
        quickSorty(src,index+1,right);
        //print(src);System.out.println("third=============");
    }
    //模拟快速排序--一次排序
    int quickSort(int[] src,int left,int right) {
        /**
         * 取数组第一个数作为值value，
         * 从右边开始遍历，当值小于value时，交换两个的位置；
         * 然后从左边开始遍历，大于value的值，交换两个位置，直到指针碰撞
         */
        int value = src[left];
        System.out.println("indexKey" + value);
        int il = left;//当前遍历到的左指针位置
        int ir = right;//当前遍历到的右指针位置
        int keyIndex = il;
        int temp = 0;
        boolean flag = true;//初始指针从右侧执行
        //右侧遍历
        while (ir >=il) {
            System.out.println(il + "----------------->" + ir);
            //指针碰撞处理
            if (ir == il) {
                if (flag) {
                    if (src[ir] < value) {
                        swap(src, value, keyIndex, ir);
                        keyIndex = ir;
                    }
                } else {
                    if (src[il] > value) {
                        swap(src, value, keyIndex, il);
                        keyIndex = il;
                    }
                }
                break;
            }
            if (flag) {
                for (int i=ir; i >= il; i--) {
                    if (src[i] < value) {
                        swap(src, value, keyIndex, i);
                        il = keyIndex + 1;//将左边的指针加1
                        keyIndex = i;
                        i--;
                        ir = i;//将右边的指针减1
                        flag = false;
                        break;
                    }
                    if(i == il)
                        ir = il;
                }

            } else {
                //左侧遍历

                for (int i=il; i <=ir; i++) {
                    if (src[i] > value) {
                        swap(src, value, keyIndex, i);
                        ir = keyIndex - 1;
                        keyIndex = i;
                        i++;
                        il = i;
                        flag = true;
                        break;
                    }
                    if(i == ir)il=ir;
                }
            }
        }
        return keyIndex;
    }

    private void swap(int[] src, int value, int keyIndex, int i) {
        int temp;
        temp = src[i];
        src[i] = value;
        src[keyIndex] = temp;
    }
}
