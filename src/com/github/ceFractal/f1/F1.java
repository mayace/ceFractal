package com.github.ceFractal.f1;

import com.github.gg.Dict;
import com.github.gg.Sim;
import com.github.gg.TModifier;
import com.github.gg.TRol;
import com.github.gg.TType;
import java.awt.GraphicsEnvironment;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class F1 {

    public static void main(String[] args) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final String[] fonts = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            final String f = fonts[i];
            System.out.println(f);
        }
        
    }
    
    
}
