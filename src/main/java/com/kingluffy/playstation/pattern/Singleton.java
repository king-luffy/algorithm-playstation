package com.kingluffy.playstation.pattern;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.pattern
 * @ClassName: Singleton
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/6 9:36 PM
 * @Version: 1.0
 */
public class Singleton {

    private Singleton(){}

    private static class SingletonHoder{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHoder.instance;
    }
}
