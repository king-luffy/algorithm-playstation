package com.kingluffy.playstation.sort;

import java.util.Arrays;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.sort
 * @ClassName: Sort
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/4/30 8:22 PM
 * @Version: 1.0
 */
public class Sort {
    private static int[] s1(int[] src){
        for(int i=0;i<src.length-1;i++){
            for(int j=src.length-1;j>i;j--){
                if(src[j-1]<src[j]){
                    swap(src,j-1,j);
                }
            }
        }
        return src;
    }
    private static int[] s2(int[] src){
        for(int i=0;i<src.length-1;i++){
            int maxIdx = i;
            for(int j=i;j<src.length;j++){

                if(src[maxIdx]<src[j]){
                    maxIdx = j;

                }
            }
            swap(src,i,maxIdx);
        }
        return src;
    }
    private static void swap(int[] src,int i,int j){
        int tmp = src[i];
        src[i]=src[j];
        src[j]=tmp;
    }


    public static class Seg{
        int[] src;
        int sb;
        int se;
        public Seg(int[] src,int sb,int se){
            this.src = src;
            this.sb = sb;
            this.se = se;
        }
    }
    private static int[] s3(int[] src){

        Seg seg = getSub(new Seg(src,0,src.length-1));

        return seg.src;

    }
    private static Seg getSub(Seg seg){

        if(seg.sb==seg.se){
            return seg;
        }

        int head = seg.sb;
        int tail = seg.se;
        int mid = (head + tail) /2 ;

        Seg left = getSub(new Seg(seg.src,head,mid));
        Seg right = getSub(new Seg(seg.src,mid+1,tail));

        return merge(left,right);
    }

    private static Seg merge(Seg left, Seg right) {

        int[] tmp = Arrays.copyOfRange(left.src,left.sb,left.se+1);
        int cur = left.sb;
        int l = 0;
        int r = right.sb;

        while (l<tmp.length || r<=right.se){

            if(r>right.se || tmp[l]<right.src[r]){
                left.src[cur]=tmp[l];
                l++;
            }else {
                left.src[cur]=right.src[r];
                r++;
            }
            cur++;

        }
        left.se = right.se;
        return left;

    }


    private static int[] s4(int[] src){

        return getSeg(src,0,src.length-1);

    }

    private static int[] getSeg(int[] src,int b,int e){
        if(b==e){
            return src;
        }
        int mid = (b+e)/2;

        src = getSeg(src,b,mid);
        src = getSeg(src,mid+1,e);

        return mergeSeg(src,b,e);

    }

    private static int[] mergeSeg(int[] src, int b, int e) {
        int[] tmp = Arrays.copyOfRange(src,b,e+1);
        int s1b = 0;
        int s1e = (tmp.length-1)/2;
        int s2b = s1e+1;
        int s2e = tmp.length-1;
        int cur = b;
        while (s1b<=s1e || s2b<=s2e){
            if(s1b>s1e){
                src[cur]=tmp[s2b];
                s2b++;
            }else if(s2b>s2e){
                src[cur]=tmp[s1b];
                s1b++;
            }
            else if(tmp[s1b]<tmp[s2b]){
                src[cur]=tmp[s1b];
                s1b++;
            }else
            {
                src[cur]=tmp[s2b];
                s2b++;
            }
            cur++;
        }
        return src;
    }

    private static int[] s5(int[] src){

        return getSeg2(src,0,src.length);

    }

    private static int[] getSeg2(int[] src,int b,int e){
        if(b+1>=e){
            return src;
        }
        int mid = (b+e)/2;

        src = getSeg2(src,b,mid);
        src = getSeg2(src,mid,e);

        return mergeSeg2(src,b,e);

    }

    private static int[] mergeSeg2(int[] src, int b, int e) {
        int[] tmp = Arrays.copyOfRange(src,b,e);
        int s1b = 0;
        int s1e = (tmp.length)/2;
        int s2b = s1e;
        int s2e = tmp.length;
        int cur = b;
        while (s1b<s1e || s2b<s2e){
            if(s1b>=s1e){
                src[cur]=tmp[s2b];
                s2b++;
            }else if(s2b>=s2e){
                src[cur]=tmp[s1b];
                s1b++;
            }
            else if(tmp[s1b]<tmp[s2b]){
                src[cur]=tmp[s1b];
                s1b++;
            }else
            {
                src[cur]=tmp[s2b];
                s2b++;
            }
            cur++;
        }
        return src;
    }
}
