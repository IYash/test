package com.fun;

/**
 * Created by huangchangling on 2018/7/23.
 * 通过分治算法：分解，解决，合并
 * 将数组分割成多个区间
 * 这是一种基于相同方向移动下标的处理方式
 * 也可以从两个方向完成,具体参考MyArrayUtil中的实现
 */
public class MyQuickSort {
    /**
     * 将主元归置到正确的位置上
     * @param A
     * @param p
     * @param r
     * @return
     */
    static int partition(int[] A,int p,int r){
        int x = A[r];//当前选择的主元
        int i = p-1;//起始位置
        for(int j=p;j<r;j++){//划分区域,j-r之间的分组大于主元，p-i之间的分组小于主元
            if(A[j]<x){
                i ++;
                exchange(A,i,j);
            }
        }
        exchange(A,i+1,r);//i位置上的元素小于x
        return i+1;
    }
    static void exchange(int[] A,int i,int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    static void quickSort(int[] A,int p,int r){
        if(p<r){//递归条件，单元素时退出递归
            int q = partition(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }

    public static void main(String[] args) {
        int[] A= {2,8,7,1,3,5,6,4};
        quickSort(A,0,A.length-1);
        for (int i:A
             ) {
            System.out.println(i);
        }
    }
}
