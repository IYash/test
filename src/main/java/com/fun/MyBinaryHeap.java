package com.fun;

/**
 * Created by Administrator on 2018/3/30.
 * 暂不考虑堆的扩展
 */
public class MyBinaryHeap {

    static int MAX_SIZE = 64;
    //堆结构性
    int currentSize = 0;
    int[] array;

    //堆序性----最小堆（根节点小于任意的其子节点）
    public MyBinaryHeap() {
        array = new int[MAX_SIZE];
    }

    /**
     * 将x插入到堆中
     *
     * @param x
     */
    public void insert(int x) {
        int hole;//满足堆序性条件下允许插入的位置
        if (currentSize >= MAX_SIZE - 1) return;
        else {
            hole = ++currentSize;//维护currentSize同时确认可以插入的位置
            for (; hole > 1 && array[hole / 2] > x; hole /= 2) array[hole] = array[hole / 2];
            array[hole] = x;
        }
    }

    /**
     * 删除最小元
     *
     * @return
     */
    public int deleteMin() {
       int tmp = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return tmp;
    }

    /**
     * 下滤动作，将空穴位置下滤
     *
     * @param hole
     */
    private void percolateDown(int hole) {
        int tmp = array[hole];
        int child;
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child +1 <= currentSize && array[child] > array[child + 1]) child++;
            if(tmp > array[child]) array[hole] = array[child];else break;
        }
        array[hole] = tmp;
    }
}