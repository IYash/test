package com.fun;

/**
 * @author huangchangling on 2017/9/8 0008
 */
public class MathFun {
    /**
     * 欧几里得算法，计算两个数的最大公因数
     */
    public static long maxFactor(long a,long b){
        long x = Math.max(a,b);
        long y = Math.min(a,b);
        while(y!=0){
            long rem = x % y;
            x = y;
            y= rem;

        }
        return x;
    }
    /**
     * 幂运算,简单的可以通过进行N次的相乘得到，可以考虑N = N/2 + N/2(N-1/2+N-1/2)来减少运算次数
     */
    public static long power(long under,int upper){
        if (upper == 0) return 1;
        if(upper % 2 ==0)
        return power(under*under,upper/2);
        else
        return power(under*under,upper/2)*under;
    }
}
