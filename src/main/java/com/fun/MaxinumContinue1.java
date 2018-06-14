package com.fun;

/**
 * Created by huangchangling on 2018/6/14.
 * 关于获取数组输入中最大的连续数字的一种实现
 * 例如[1,3,4,5,6,8]则最大连续数为4
 */
public class MaxinumContinue1 {

    //将当前位置向后推移，记录当前的最大连续个数，替换
    public static int getMaxContinue(int[] src){
        int maxCount = 1;
        int currentMaxCount = 1;
        int currentNum = src[0];
        int len = src.length;
        int i=1;
        while(i<len){
            if(src[i] == currentNum +1){
                currentMaxCount +=1;
                if(maxCount < currentMaxCount) maxCount = currentMaxCount;
            }else{
                currentMaxCount= 1;
            }
            currentNum = src[i];
            i++;
        }
        System.out.println(maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] src = {1,3,4,5,6,8,9,10,11,12,13};
        getMaxContinue(src);
    }
}
