package com.kingluffy.playstation.no202;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no202
 * @ClassName: IsHappy
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/4/30 8:15 PM
 * @Version: 1.0
 */
public class IsHappy {

    public boolean isHappy(int src) {

        int quick = src;
        int slow = src;
        int step = 1;

        if(src==1){
            return true;
        }

        while (true){
            if(step%2==0){
                slow = getSquare(slow);
            }
            quick = getSquare(quick);

            if(quick==1){
                return true;
            }

            if(slow==quick){
                return false;
            }

            step++;
        }

    }

    private static int getSquare(int src){
        int remainder;
        int quotient=src;
        int cur = 0;

        while (quotient>0){

            remainder = quotient % 10;
            quotient = quotient / 10;

            cur += remainder * remainder;

        }

        return cur;
    }

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        isHappy.isHappy(3);
    }

}
