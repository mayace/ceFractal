package com.github.ceFractal.f1;

import com.github.gg.Dict;
import com.github.gg.Sim;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class F1 {

    public static void main(String[] args) {
        
//        Path p = Paths.get(System.getProperty("user.home"));
//        
//        System.err.println(p.toString());
//        System.out.println(p.resolve("Users").toString());
//        
//        Dict d = new Dict(){{
//            put("ss", 1);
//            
//        }};
       
        System.err.println("<proyecto".substring(1));
        System.err.println("</proyecto>".substring(2,"</proyecto>".lastIndexOf('>')));
        
        System.out.println(Arrays.toString(Sim.class.getDeclaredFields()));
        
    }
    
}
