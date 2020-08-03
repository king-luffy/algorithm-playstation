package com.kingluffy.playstation;

import java.util.List;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation
 * @ClassName: Test
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/22 7:23 PM
 * @Version: 1.0
 */
public class Test {



    class Emploor{
        private String id;
        private Long income;
        private List<Long> incomes;//有序
    }



    public static void main(String[] args) {
        //csv
        //列 1：员工工号 String
        //列 2：员工单笔收入
        //


        //String 1 String 2
        //公共字串

        //max

        //***abcde
        //acde

        //***abcde
        //*acde

        //***abcde
        //**acde

        //***abcde
        //****acde
//        String src1= "abcde";
//        String src2="acde";


        String src1= "abcddefff";
        String src2="acddebbbb";
//        String src1= "abcddefffcdefgaa";
//        String src2="acddebbcdefgbb";
        String res = maxSub(src1,src2);
        System.out.println(res);
    }

    public static String maxSub(String src1,String src2){

        int l2 = src2.length();
        int l1 = src1.length();

        int b =0;
        int e =0;
        int max= 0;


        for(int i=l2-1;i>=0;i--){

            String sub2 = src2.substring(i,l2);
            int idx= 0;
            int tmpM = 0;
            int tmpB =0;
            int tmpE =0;
            while(idx<sub2.length() && idx<l1){

                //相等更新最长字串
                if(sub2.charAt(idx)==src1.charAt(idx)){
                    tmpE = idx;
                    tmpM = tmpE-tmpB;
                    if(tmpM>max){
                        b= tmpB;
                        e=tmpE;
                        max=tmpM;
                    }
                }else{

                    //不相同重新计数
                    tmpB=idx;
                    tmpE=idx;
                }

                idx++;
            }

        }


        int b2 =0;
        int e2 =0;
        int max2 = 0;


        for(int i=0;i<l1;i++){

            String sub2 = src1.substring(i,l1);
            int idx= 0;
            int tmpM = 0;
            int tmpB =0;
            int tmpE =0;
            while(idx<sub2.length() && idx<l2){

                //相等更新最长字串
                if(sub2.charAt(idx)==src2.charAt(idx)){
                    tmpE = idx;
                    tmpM = tmpE-tmpB;
                    if(tmpM>max2){
                        b2= tmpB;
                        e2=tmpE;
                        max2 = tmpM;
                    }
                }else{

                    //不相同重新计数
                    tmpB=idx;
                    tmpE=idx;
                }

                idx++;
            }

        }

        if(max2>max){
            return src2.substring(b2+1,e2+1);
        }else{
            return src1.substring(b+1,e+1);
        }

    }
}
