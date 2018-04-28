package com.fun;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by huangchangling on 2018/4/27.
 * 贪心算法的简单理解
 * 假设如下的一个场景：
 * A,B,C,D共享一个区间[0,20]
 * A[1,6],B[7,9],C[10,15],D[14,20]则可同时活动的组合为ABC或者ABD
 * 以下的程序就是为了找出这样的一个最大序列个数
 * 未完，待续
 */
public class MyGreed {

    private List<Area> areas = new LinkedList<>();

    private static class Area implements Comparable{
        int start;
        int end;

        public Area(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Object o) {
            return ((Area)o).getEnd() >  getEnd()? 1:-1;
        }
    }

    public static void main(String[] args) {
        Area a1=new Area(1,5);
        Area a2 = new Area(6,7);
        Area a3 = new Area(2,4);
        MyGreed greed = new MyGreed();
        greed.areas.add(a1);
        greed.areas.add(a2);
        greed.areas.add(a3);
        greed.areas.sort(new Comparator<Area>() {
            @Override
            public int compare(Area o1, Area o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(greed.areas.get(2).getEnd());
    }
}
