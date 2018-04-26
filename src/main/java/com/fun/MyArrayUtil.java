package com.fun;




import java.util.Random;

/**
 * @author huangchangling on 2017/9/4 0004
 */
public class MyArrayUtil {



    //希尔排序--缩短步长的方式进行排序，最终的步长为1
    public static void shellSort(int[] src){

        int j;

        for(int gap=src.length/2;gap>0;gap /=2){//设置步长

            for(int i=gap;i<src.length;i++){//遍历元素,对i,i+gap,i+2gap...上的元素进行排序

                int temp = src[i];

                for(j=i; j>= gap && temp < src[j-gap];j -= gap)

                    src[j] = src[j-gap];

                src[j]=temp;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] src,int left,int right){

      for(int i=left+1;i<=right;i++){

          if(src[i] < src[i-1]){//当前位置小于前一个数
              int x = src[i];
              int j;
            for(j=i-1;j>=left && src[j]> x;j--){//当前位置大于前一个数
                src[j+1] = src[j];
            }
            src[j+1] = x;
          }
      }
    }
    //快速排序
    public static void quickSort(int[] src,int lo,int hi){
        if(lo>=hi) return;
        int index = getKeyIndex(src,lo,hi);
        quickSort(src,lo,index-1);
        quickSort(src,index+1,hi);
    }
    //一次排序中获取基准值的位置,然后进行左右递归排序
    private static int getKeyIndex(int[] src,int lo,int hi){
        int val = src[lo];
        while(lo < hi){
            //右侧指针移动,升序排序
            while(src[hi] >= val && hi > lo){
                hi--;
            }
            src[lo] = src[hi];
            //左侧指针移动
            while(src[lo] <= val && lo < hi){
                lo ++;
            }
            src[hi]=src[lo];
        }
        src[lo] = val;
        return hi;
    }
    public static int[] getSrc(int keyNum,int range){
        int[] arr = new int[keyNum];
        while(keyNum >0){
            arr[--keyNum]=new Random().nextInt(range);
        }
        return arr;
    }
    public static void printArr(int[] src){
        for (int i=0;i<src.length;i++){
            System.out.println(src[i]);
        }
    }
    /**
     * 最大子序列的和的问题
     */
    public static int maxsub(int[] src){
        int maxSum = 0;
        int len = src.length;
        for(int i=0;i<len-1;i++){

            int cycleSum = 0;

            for(int j=i;j<len;j++){

                cycleSum +=src[j];

                if(cycleSum > maxSum) maxSum = cycleSum;

            }
        }
        return maxSum;
    }
    public static int maxsub1(int[] src){
        int maxSum = 0;
        int len =src.length;
        int cycleSum = 0;
        for(int i=0;i<len;i++){
                cycleSum += src[i];
                if(cycleSum > maxSum) maxSum = cycleSum;
                else if(cycleSum < 0 ) cycleSum =0;//小于0表示以i开始的子序列不适合作为最大子序列的开始,cycleSum重新计数
            }
        return maxSum;
    }

    /**
     * 将数组进行分组递归，当left=right是跳出，若src[left] > 0 则返回src[left],否则返回0
     * @param src
     * @param left
     * @param right
     * @return
     */
    public static int maxsub2(int[] src,int left,int right){
        if(left == right) if(src[left] >0 ) return src[left]; else return 0;

        int center = (left + right)/2;
        int maxLeftSum = maxsub2(src,left,center);
        int maxRightSum = maxsub2(src,center+1,right);
        int leftBoarderSum=0,maxLeftBoardSum=0;
        //求左边界的和
        for(int i=center;i>=left;i--){
            leftBoarderSum += src[i];
            if(leftBoarderSum > maxLeftBoardSum) maxLeftBoardSum = leftBoarderSum;
        }
        //求右边界的和
        int rightBoarderSum=0,maxRightBoardSum=0;
        for(int i=center+1;i<=right;i++){
            rightBoarderSum += src[i];
            if(rightBoarderSum > maxRightBoardSum) maxRightBoardSum = rightBoarderSum;
        }
        return max(maxLeftSum,maxRightSum,maxLeftBoardSum+maxRightBoardSum);
    }
    private static int max(int a,int b,int c){
        return a>b?(a>c?a:c):(b>c?b:c);
    }
    public static void main(String[] args) {
        int[] src = new int[]{4,-3,2,1};
        System.out.println(maxsub2(src,0,src.length-1));
//        System.out.println(maxsub1(src));
//        System.out.println(maxsub(src));
    }
}
