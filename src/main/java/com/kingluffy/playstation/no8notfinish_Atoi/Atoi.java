package com.kingluffy.playstation.no8notfinish_Atoi;


/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no8notfinish_Atoi
 * @ClassName: Atoi
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/19 9:39 PM
 * @Version: 1.0
 */
public class Atoi {


    public int myAtoi(String str) {
        str = str.trim();
        int res = 0 ;

        // +/- -> 数字
        int status = 0;
        int negative = 1;
        for(int i=0;i<str.length();i++){


            char cur = str.charAt(i);

            if(status==0){

                if('+'==cur){

                }else if('-'==cur){
                    negative= negative*-1;
                }
                else if(Character.isDigit(cur)){
                    if(overBorder(res,negative)){
                        res= getMax(negative);
                        break;
                    }
                    res = add(res,cur);

                }else {
                    break;
                }
                status = 1;

            }else if(status==1){
                if(Character.isDigit(cur)){
                    if(overBorder(res,negative)){
                        res= getMax(negative);
                        break;
                    }
                    res = add(res,cur);
                }else {
                    break;
                }

            }
        }

        return res*negative;
    }
    boolean overBorder(int res,int negative){
        if(negative>0){
            if(res>=(Integer.MAX_VALUE-1)/10){
                return true;
            }
        }else {
            if(res*negative<=Integer.MIN_VALUE/10){
                return true;
            }
        }
        return false;
    }
    int getMax(int negative){
        if(negative>0){
            return Integer.MAX_VALUE-1;
        }else {
            return Integer.MIN_VALUE;
        }
    }

    int add(int res,char num){
        return res * 10 + (num-'0');
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        String t = "2147483647";
        Atoi atoi = new Atoi();
        int res = atoi.myAtoi(t);
        System.out.println(res);
    }

}
