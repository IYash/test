package com.fun;

/**
 * Created by huangchangling on 2018/7/18.
 * 动态规划初试
 * 需求：求出一下数字三角形的最大路径和，路径跨度不能超过1即D(R,J)可以通过的元素为D(R+1，J)或者D(R+1,J+1)
 * 输入格式：
 5      //表示三角形的行数    接下来输入三角形
 7
 3   8
 8   1   0
 2   7   4   4
 4   5   2   6   5
 */
public class Dynamic {


    /**
     * 一下是最基本的处理方式
     */
    //组织数据的一种方式
          static  int n = 5;
   static int[][] d = new int[5][5];
    //组织结果集的方式一
   static int[][] resultTmp = d;
    //组织结果集的方式二
    static int[] resultTmp1 = d[4];
    //对数据初始化的一种方式
   static{
       d[0][0]=7;d[1][0]=3;d[1][1]=8;
       d[2][0]=8;d[2][1]=1;d[2][2]=0;
       d[3][0]=2;d[3][1]=7;d[3][2]=4;d[3][3]=4;
       d[4][0]=4;d[4][1]=5;d[4][2]=2;d[4][3]=6;d[4][4]=5;
   }
   //最后一行的值可以作为resultTmp的值，自底向上计算每条路径上的值
   static void fillResultTmp(int r,int j){
       if(r < n-1){//r==n时不需要修改resultTmp的值
           resultTmp[r][j] = Math.max(resultTmp[r+1][j],resultTmp[r+1][j+1])+d[r][j];
       }
   }
    static void fillResultTmp1(int r,int j){
        if(r<n-1){
            resultTmp1[j] = Math.max(resultTmp1[j],resultTmp1[j+1])+d[r][j];
        }
    }
    public static void main(String[] args) {
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                //fillResultTmp(i,j);
                fillResultTmp1(i,j);
            }
        }
        System.out.println(resultTmp1[0]);
    }


}
