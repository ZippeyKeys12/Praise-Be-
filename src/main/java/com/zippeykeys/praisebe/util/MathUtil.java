package com.zippeykeys.praisebe.util;

import lombok.experimental.UtilityClass;


@UtilityClass
public class MathUtil{
    public static int clamp(int val, int min, int max){
        return Math.max(min, Math.min(max, val));
    }

    public static double clamp(double val, double min, double max){
        return Math.max(min, Math.min(max, val));
    }
}