package com.kingluffy.playstation.no76_MinWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no76_MinWindow
 * @ClassName: MinWindow
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/23 9:45 PM
 * @Version: 1.0
 */
public class MinWindow {

    class SubString{
        int min =0;
        int max =0;
        int secondAlph =0;
        int len(){
            return max-min;
        }
    }
    public String minWindow(String s, String t) {

        SubString minSub = null;


        int idx = 0;
        // 从左到右
        while(idx<s.length()-t.length()+1){

            SubString cur = findSubEnd(idx,s,t);

            if(cur!=null){
                if(minSub==null){
                    minSub = cur;
                }else{
                    if(cur.len()<minSub.len()){
                        minSub = cur;
                    }
                }
            }
            idx++;

            //跳转优化
            if(cur!=null && cur.secondAlph >idx){
                idx=cur.secondAlph;
            }


        }

        if(minSub==null){
            return "";
        }
        return s.substring(minSub.min,minSub.max);
    }

    private SubString findSubEnd(int idx, String s, String t) {
        SubString ss = new SubString();
        ss.min= idx;

        Map<Character,Integer> charMap = new HashMap<>();
        for (Character c:t.toCharArray()) {
            if(charMap.containsKey(c)){
                charMap.put(c,charMap.get(c)+1);
            }else {
                charMap.put(c, 1);
            }
        }
        int second = 0;
        Character firstChar = null;


        for(int i=idx;i<s.length();i++){
            char tmp = s.charAt(i);
            if(firstChar!=null && second==1 && tmp==firstChar){
                ss.secondAlph=i;
            }

            if(charMap.containsKey(tmp)){


                second++;
                if(second==1){
                    firstChar = tmp;
                }

                // 优化记录第二个字母
                if(second==2 && ss.secondAlph==0){
                    ss.secondAlph =i;
                }

                // 获取重复字母数
                int count = charMap.get(tmp);
                count--;
                if(count<=0) {

                    //重复字母清零

                    charMap.remove(tmp);

                    if (charMap.isEmpty()) {
                        ss.max = i + 1;
                        return ss;
                    }
                }else {
                    //重复字母没清零
                    charMap.put(tmp,count);
                }
            }

            // 第一个字母需要跳过
            if(second==0){
                ss.min=i+1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "bba";
        String t = "ab";
        // "bc"
        MinWindow mw = new MinWindow();
        String res = mw.minWindow(s,t);
        System.out.println(res);
    }
}
