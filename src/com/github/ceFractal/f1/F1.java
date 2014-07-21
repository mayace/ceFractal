package com.github.ceFractal.f1;

import com.github.gg.OptExpr;
import com.github.gg.OptIf;
import java.awt.GraphicsEnvironment;

public class F1 {

    public static void main(String[] args) {

        System.out.println(new OptIf(new OptExpr(">", 1, 2), args).toString().replaceAll("<", "\\<").replaceAll(">", "\\>"));
    }

}
