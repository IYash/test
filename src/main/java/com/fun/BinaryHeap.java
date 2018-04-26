package com.fun;



/**
 * @author huangchangling on 2017/9/6 0006
 * @Description 二叉堆,简单的以整型为例
 */
public class BinaryHeap {
    /**
     * 描述二叉堆的长度
     */
    int currentSize;
    int[] array;
    public BinaryHeap(){}
    /**
     * 根据一个已有的数组构建二叉堆
     */
    public BinaryHeap(int[] src){
        currentSize = src.length;
        array = new int[(currentSize+2)*11/10];
        int i=1;
        for(int item:src)
            array[i++]=item;
        buildHeap();
    }

    /**
     * 构建二叉堆
     */
    private void buildHeap(){
        for(int i= currentSize/2;i>0;i--) percolateDown(i);
    }

    /**
     * 下滤
     * @param hole
     */
    private void percolateDown(int hole){
        int tmp = array[hole];
        int child;

        for(;hole*2<=currentSize;hole = child){
            child = hole *2 ;
            //找出子元素中小的,在这个分支路径上进行下滤
            if(child != currentSize && array[child+1] < array[child]) child++;
            if(tmp > array[child]) array[hole] = array[child];else break;
        }
        array[hole] = tmp;
    }

    /**
     * 将元素x插入二叉堆
     * @param x
     */
     public void insert(int x){//上滤
         int hole = ++currentSize;
         for(;hole>1 && array[hole/2] > x;hole /=2) array[hole] = array[hole/2];
         array[hole] = x;
     }

    /**
     * 移除最小的元素
     * @return
     */
    public int deleteMin(){
        int min = findMin();
        array[1] = array[currentSize--];
        //需要对二叉堆进行下滤
        percolateDown(1);
        return min;
    }

    /**
     * 查找最小的元素
     * @return
     */
    private int findMin(){
        return array[1];
    }

    /**
     * 堆排序，不拓展新的数组的方式;
     * @param src
     */
    public static void heapSort(int[] src){
        //构建二叉堆
        for(int i= src.length/2;i>=0;i--) percDown(src,i,src.length);
        //移除到数组末端
        for(int i=0;i<src.length;i++){
            swapReference(src,0,src.length-i);
            percDown(src,0,src.length-i-1);
        }
    }

    /**
     * 交换数组中的两个数
     * @param src
     * @param i
     * @param n
     */
    private static void swapReference(int[] src,int i,int n){
        int tmp = src[i];
        src[i] = src[n-1];
        src[n-1] = tmp;
    }

    /**
     * 下滤
     * @param src
     * @param i
     * @param n
     */
    private static void percDown(int[] src,int i,int n) {
        int child ;
        int tmp = src[i];
        for (; leftChild(i) < n;i = child){
            child = leftChild(i);
        if (child != n-1 && src[child] > src[child + 1]) child++;
        if (tmp > src[child]) src[i] = src[child]; else break;
        }
        src[i] = tmp;
    }
    /**
     * 第i个节点的左子节点
     * @param i
     * @return
     */
    private static int leftChild(int i){
        return 2*i+1;
    }
    public static void main(String[] args) {
            int[] src = new int[]{31,41,59,26,53,58,97};
           /* BinaryHeap heap =  new BinaryHeap(src);
            MyArrayUtil.printArr(heap.array);
        System.out.println("--------------------");
            heap.insert(11);
        MyArrayUtil.printArr(heap.array);
        heap.deleteMin();
        heap.deleteMin();
        System.out.println("--------------------");
        MyArrayUtil.printArr(heap.array);*/
        heapSort(src);
        MyArrayUtil.printArr(src);
    }
}
