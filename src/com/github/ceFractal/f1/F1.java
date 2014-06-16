package com.github.ceFractal.f1;

import com.github.gg.Dict;
import com.github.gg.Sim;
import com.github.gg.TModifier;
import com.github.gg.TRol;
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
//       
//        System.err.println("<proyecto".substring(1));
//        System.err.println("</proyecto>".substring(2,"</proyecto>".lastIndexOf('>')));
//        
//        System.out.println(Arrays.toString(Sim.class.getDeclaredFields()));
//        
//        int i = 0;
//        
//        System.err.println(i++ -1);
        
        
//        Object[][] obj =new Object[][]{{11,12,13},{111,112,113}};
//        
//        System.err.println(obj.length);
//        System.err.println(obj[0].length);
//        
//        for (int i = 0; i < obj.length; i++) {
//            Object[] rows = obj[i];
//            for (int j = 0; j < rows.length; j++) {
//                Object cell = rows[j];
//                System.err.println(cell);
//            }
//        } 
        
        class a extends Sim{

            public a(TRol rol, String scope, int position, int size, HashSet<TModifier> modifiers, Object type, String name, Sim parent) {
                super(rol, scope, position, size, modifiers, type, name, parent);
            }
        }
        class b extends a{

            public b(TRol rol, String scope, int position, int size, HashSet<TModifier> modifiers, Object type, String name, Sim parent) {
                super(rol, scope, position, size, modifiers, type, name, parent);
                
            }
        }
    }
    
}
