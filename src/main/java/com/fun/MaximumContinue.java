package com.fun;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huangchangling on 2018/4/27.
 * 关于获取数组输入中最大的连续数字的一种实现
 * 例如[1,3,4,5,6,8]则最大连续数为4
 */
public class MaximumContinue {

    /**g
     * 通过contain判断一个集合是否包含某个元素
     * @param s
     * @param in
     * @param len
     * @return
     */
    public static int getCurrentMaxCon(Set s,int in,int len){
        if(s.contains(in)){
            return getCurrentMaxCon(s,++in,++len); //in的下一个是否也在s中
        }else{
            return len;
        }
    }

    /**
     * 获取最大的连续数
     * @param source
     * @return
     */
    public static int getTotalMaxCon(int[] source){
        Set s = new HashSet<>();//set的contain操作时间复杂度O(1)
       for(int i:source) s.add(i);
        int maxLen = 1;
        for(int i:source){//这个思路存在一个问题，就是重复统计
            int cLen = 0;
            cLen = getCurrentMaxCon(s,i,cLen);
            if (cLen > maxLen) maxLen = cLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] source = new int[]{2,3,4,6,7,8,1};
        int len = getTotalMaxCon(source);
        System.out.println(len);
    }
}
