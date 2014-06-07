package com.github.ceFractal.f1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class F1 {

    public static void main(String[] args) {
        
        Path p = Paths.get(System.getProperty("user.home"));
        
        System.err.println(p.toString());
        System.out.println(p.resolve("Users").toString());
    }
    
}
