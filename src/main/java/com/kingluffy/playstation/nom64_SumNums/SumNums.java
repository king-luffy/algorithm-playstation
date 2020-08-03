package com.kingluffy.playstation.nom64_SumNums;

/**
 *
 * 1+2+...+n
 * 不允许使用for while if
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation
 * @ClassName: SumNums
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/2 9:05 PM
 * @Version: 1.0
 */
public class SumNums {
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n>0 && (sum += sumNums(n-1))>0 ;
        return sum;
    }

    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        int res = sumNums.sumNums(5);
        System.out.println(res);

    }
}
