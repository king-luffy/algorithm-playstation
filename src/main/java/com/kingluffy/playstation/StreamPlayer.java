package com.kingluffy.playstation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamPlayer {

    public static List<Integer> list = Arrays.asList(1,2,3,5,4);

    public static List<String> listStr = Arrays.asList("a","b","d","cc");


    public static void printEach(){
        list.stream().forEach(System.out::println);
    }

    public static void addOne(){
        list.stream().map(x->x=x+1).forEach(System.out::println);
    }

    public static void biggerThan3(){
        list.stream().filter(x->x>3).forEach(System.out::println);
    }

    public static void sort(){
        list.stream().sorted().forEach(System.out::println);
    }

    //逆序加一大于2输出
    public static void reverseAddOneSort(){
        list.stream().map(x->x+1).filter(x->x>2).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Integer list:");
        printEach();
        System.out.println("Integer add one:");
        addOne();
        System.out.println("Integer bigger than 3:");
        biggerThan3();
        System.out.println("Sorted:");
        sort();
        System.out.println("逆序加一大于2输出:");
        reverseAddOneSort();
    }

}
