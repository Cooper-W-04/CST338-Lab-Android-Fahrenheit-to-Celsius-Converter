package com.example.ctof_inclass_338;

public class Utils {
    public static Double cTof(Double c){
        return (c * 1.8) + 32;
    }

    public static Double fToc(Double f){
        return (f-32)/1.8;
    }
}
