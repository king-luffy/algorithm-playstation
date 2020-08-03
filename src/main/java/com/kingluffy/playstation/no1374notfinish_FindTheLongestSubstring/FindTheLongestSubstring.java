package com.kingluffy.playstation.no1374notfinish_FindTheLongestSubstring;

/**
 *
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 *
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no1374notfinish_FindTheLongestSubstring
 * @ClassName: FindTheLongestSubstring
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/20 9:29 PM
 * @Version: 1.0
 */
public class FindTheLongestSubstring {
    class Vowel{
        int an = 0;
        int en = 0;
        int in = 0;
        int on = 0;
        int un = 0;
        private boolean isDouble(){
            return an%2==0 && en%2==0 && in%2==0 && on%2==0 && un%2==0;
        }

        private void addNum(char c){
            if(c=='a'){
                an++;
            }else if(c=='e'){
                en++;
            }else if(c=='i'){
                in++;
            }else if(c=='o'){
                on++;
            }else if(c=='u'){
                un++;
            }
        }
    }
    public int findTheLongestSubstring(String s) {
        int res = 0;

        //从每个字符开始
        int i=0;
        while (i<s.length()){
            int nextStep = i+1;
            Vowel vowel = new Vowel();
            int curMax =0;

            //每个字符从左往右计算
            for(int j=i;j<s.length();j++){

                char cur = s.charAt(j);
                vowel.addNum(cur);
                //如果是double状态，则记录最大值
                if(vowel.isDouble()){
                   curMax = j-i+1;
                   nextStep = j+1;
                }
            }

            //更新最大值
            if(curMax>res){
                res = curMax;
            }
            i = nextStep;

        }

        return res;
    }

    // 结果正确，但是计算效率太低，使用状态压缩来做
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        FindTheLongestSubstring substring = new FindTheLongestSubstring();
        int res = substring.findTheLongestSubstring(s);
        System.out.println(res);
    }


}
