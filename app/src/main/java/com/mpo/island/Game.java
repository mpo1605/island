package com.mpo.island;

public class Game {
    public static boolean dead;
    public static boolean dontSeenResult;
    public static int health;
    public static int food;
    public static int temp;
    public static int stage = 0;


    public static boolean death(){
        return (health <= 0) || (food <= 0) || (temp <= 0);
    }
    public static boolean death_health(){
        return health <= 0;
    }
    public static boolean death_food(){
        return food <= 0;
    }
    public static boolean death_temp(){
        return temp <= 0;
    }

}
