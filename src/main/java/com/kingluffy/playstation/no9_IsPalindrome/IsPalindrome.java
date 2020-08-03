package com.kingluffy.playstation.no9_IsPalindrome;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no9_IsPalindrome
 * @ClassName: IsPalindrome
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/10 7:22 PM
 * @Version: 1.0
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        int len = s.length();
        int i = 0;
        int j = len-1;

        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int src = -121;
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean res = isPalindrome.isPalindrome(src);
        System.out.println(res);
    }
}
