package com.kingluffy.playstation.no5_LongestPalindrome;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no5_LongestPalindrome
 * @ClassName: LongestPalindrome
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/21 9:14 PM
 * @Version: 1.0
 */
public class LongestPalindrome {

    class SubString{
        int b;
        int e;
        int getlength(){
            return e-b;
        }

        public SubString(int b, int e) {
            this.b = b;
            this.e = e;
        }
    }

    public String longestPalindrome(String s) {
        if("".equals(s)){
            return "";
        }
        s= "&"+s+"^";
        SubString res = new SubString(0,2);

        for(int i=1;i<s.length()-1;i++){

            SubString ss = new SubString(i-1,i+1);
            getPalindrome(s,ss);
            if(ss.getlength()>res.getlength()){
                res = ss;
            }

            SubString ss2 = new SubString(i,i+1);
            getPalindrome(s,ss2);
            if(ss2.getlength()>res.getlength()){
                res = ss2;
            }

        }
        return s.substring(res.b+1,res.e);
    }

    private void getPalindrome(String s,SubString ss){
        if(s.charAt(ss.b)!=s.charAt(ss.e)){
            ss.e=ss.b+1;
            return;
        }
        while (s.charAt(ss.b)==s.charAt(ss.e) && ss.b>0 && ss.e<s.length()){
            ss.b-=1;
            ss.e+=1;
        }


    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(s);
        LongestPalindrome palindrome = new LongestPalindrome();
        String res = palindrome.longestPalindrome(s);
        System.out.println(res);
    }



}
