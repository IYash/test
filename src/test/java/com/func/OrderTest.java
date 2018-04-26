package com.func;

import org.junit.Test;

import java.util.Random;

/**
 * @author huangchangling on 2017/9/1 0001
 */
public class OrderTest {



    @Test
    public void test1(){
        int[] src = getSrc(1000,200000);
        System.out.println("++++++++++++++++++++++++++");
        long beginTime = System.currentTimeMillis();
        order1(src);
       // getIndexK(5,src);
        long endTime = System.currentTimeMillis();
        for(int i=0;i<src.length;i++){
            System.out.println(src[i]);
        }
        System.out.println("-------------------:"+ (endTime-beginTime));
    }
    public int getIndexK(int k,int[] src){
        //不排序，获取第K大的数,效率低下
        int ret = 0;
        int[] tar = new int[src.length];
        for(int i=0;i<src.length-1;i++){
            int index = 0;
            for(int j=i;j<src.length;j++){
                if(src[i]>src[j]){
                    tar[i] = ++index;
                }
            }
        }
        for(int i=0;i<tar.length;i++) {
            if (tar[i] == k) {
                ret = src[i];
            }
        }
        System.out.println(ret+"<---------------------");
        return ret;
    }
    public void order1(int[] src){
        //排序耗时
        int temp = 0;
        for (int i=0;i<src.length-1;i++){
            for(int j=i;j<src.length;j++){
                if(src[i] > src[j]){
                    temp = src[j];
                    src[j] =src[i];
                    src[i] =temp;
                }
            }
        }
    }

    /**
     * 以开始元素做为key，从另一侧开始遍历
     * 1.位置k的值a[k]小于key时，交换a[k]和key的位置
     * 2.从key的下一个开始向相反方向遍历，当a[m]>key时，交换a[m]和key的位置
     * 当k==m时表示一次排序结束，此时key左边的值都小于key右边的值
     * @param src
     * @param left
     * @param right
     */
    public void quickSort(int[] src,int left,int right){
        int key = src[left];
        int keyIndex =left;//指示当前key所在的位置
        int il=left;//交换左边元素的位置
        int ir=right;//交换右边元素的位置
        System.out.println("begin---------"+key);
        while(ir>il){
            for(int i = ir;i>il;i--){
                if(src[i] < key) {
                    //交换src[left]和src[i]
                    int temp = src[i];
                    src[i] = src[keyIndex];
                    src[keyIndex] = temp;
                    keyIndex = i--;
                    ir = i;
                    il++;
                    break;
                }
            }
            for(int j=il;j<ir;j++){
                if(src[j]>key){
                    int ntemp = src[j];
                    src[j] = src[keyIndex];
                    src[keyIndex]  =ntemp;
                    keyIndex = j++;
                    il= j;
                    ir--;
                    break;
                }
            }
            }
        }
    @Test
    public void testCycle(){
        int[] src = getSrc(5,1000);/*new int[]{161,744,750,159,855};*/
        quickSort(src,0,src.length-1);
        for(int i=0;i<src.length;i++) System.out.println(src[i]+"---------end");
    }
    int[] getSrc(int num,int max){
        int[] src = new int[num];
        for (int i=0;i<num;i++){
            src[i] = new Random().nextInt(max);
            System.out.println(src[i]);
        }
        return src;
    }
    //用二分法求出第K大的数
    int getIndexGroup(int[] src,int k){
        int result =0;
        if(src.length==1) return src[0];
        int leftCount=0;
        int rightCount=0;
        int len =src.length;
        //求平均数
        int sum = getSum(src);
        int ceilAver = sum%len==0?sum/len:sum/len +1;
        System.out.println("ceilAAver:--------------------->"+ceilAver);
        //遍历数组将数组分段
        for(int i=0;i<len;i++){
            if(src[i]>=ceilAver) rightCount++;else leftCount++;
        }
        if(k>leftCount)
        {
            int[] right; right = new int[rightCount];
            int rightIndex =0;
            for(int i=0;i<len;i++){
                if(src[i]>=ceilAver){
                    right[rightIndex++]=src[i];
                    System.out.println(src[i]+"------------:right");
                }
            }
           result =getIndexGroup(right,k-leftCount);
        }else{
            int[] left = new int[leftCount];
            int leftIndex =0;
            for(int i=0;i<len;i++){
                if(src[i]<ceilAver){
                    left[leftIndex++]=src[i];
                    System.out.println(src[i]+"------------:left");
                }
            }
            result= getIndexGroup(left,k);
        }
        return result;
    }
    @Test
    public void testGroup(){
        int[] src = getSrc(600,10000);
        System.out.println(getIndexGroup(src,400));
    }
    private int getSum(int[] src) {
        int sum = 0;
        for (int i=0;i<src.length;i++){
            sum += src[i];
        }
        return sum;
    }
}
