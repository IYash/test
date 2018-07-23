package com.fun;

/**
 * Created by huangchangling on 2018/7/23.
 * 计数排序，一种是用空间换取时间的排序方式
 * 不需要进行元素的比较
 * 假如已知输入的空间为1-n，则可将元素放入到这个n个空间的某一个位置
 */
public class MyCountSort {
    //基于0及正整数的例子
    static void countSort(int[] A,int k){
        int[] C = new int[k];
        int[] B = new int[A.length+1];//最小的数放入下标1的位置
        for(int i = 0;i<k;i++) C[i] = 0;//对C进行初始化
        //遍历A,因为A的输入范围<k
        for(int i=0;i<A.length;i++) C[A[i]] = C[A[i]]+1;
        //计数<k的值的个数
        for(int i=1;i<k;i++)
            C[i] = C[i]+C[i-1];
        //复制元素到B数组
        for(int j=A.length-1;j>=0;j--){
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]]-1;
        }
        for(int i=1;i<B.length;i++)
            System.out.println(B[i]);
    }

    public static void main(String[] args) {
        int[] A = {2,5,3,0,2,3,0,3};
        int k= 6;
        countSort(A,k);

    }


}
