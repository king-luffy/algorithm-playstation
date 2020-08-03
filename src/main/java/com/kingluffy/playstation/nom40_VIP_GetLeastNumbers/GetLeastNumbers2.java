package com.kingluffy.playstation.nom40_VIP_GetLeastNumbers;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.nom40_VIP_GetLeastNumbers
 * @ClassName: GetLeastNumbers2
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/3 8:31 PM
 * @Version: 1.0
 */
public class GetLeastNumbers2 {


    // 快排方法
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }




        return null;
    }

    public static void s(int[] src,int b,int e){
        if(b>=e){
            return ;
        }
        int base = src[b];
        int i = b;
        int j = e;
        while (i<j){
            while(src[j]>base && i<j){
                j--;
            }
            while(src[i]<=base && i<j){
                i++;
            }
            if(i<j){
                swap(src,i,j);
            }
        }
        swap(src,b,i);


        s(src,b,i-1);
        s(src,i+1,e);


    }
    public static void swap(int[] src,int i,int j){
        int tmp = src[i];
        src[i]=src[j];
        src[j]=tmp;
    }








    public static void main(String[] args) {
        //csv
        //列 1：员工工号String
        //列
    }
}
