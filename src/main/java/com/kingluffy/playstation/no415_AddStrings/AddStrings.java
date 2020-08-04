package com.kingluffy.playstation.no415_AddStrings;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no415_AddStrings
 * @ClassName: AddStrings
 * @Author: king_luffy_pc
 * @Description:
 *
 *
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * @Date: 2020/8/3 9:40 AM
 * @Version: 1.0
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int index1 = num1.length();
        int index2 = num2.length();

        int maxSize = Math.max(index1,index2);
        boolean up = false;

        for(int i = 0;i<maxSize;i++){

            index1 -= 1;
            index2 -= 1;

            Character c1 = getCharacter(num1, index1);
            Character c2 = getCharacter(num2, index2);

            int tmp = c1 - '0' + c2 - '0' + ( up?1:0 );
            sb.append(tmp%10);
            up = tmp > 9;


        }

        if(up){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    private Character getCharacter(String num1, int index1) {
        Character c1 = '0';
        if(index1>=0){
            c1 = num1.charAt(index1);
        }
        return c1;
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        AddStrings addStrings = new AddStrings();
        String res = addStrings.addStrings(num1,num2);
        System.out.println(res);
    }
}
