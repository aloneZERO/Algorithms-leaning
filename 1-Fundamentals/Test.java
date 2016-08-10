package com.leo.fundamentals;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class Test {
    public static void main (String[] args) {
//        stdDrawTest();
    	point2DTest();
    }
    
    public static void point2DTest() {
    	Point2D p1 = new Point2D(1, 1);
    	Point2D p2 = new Point2D(1, 2);
    	System.out.println(p1.distanceTo(p2));
    }
    
    /**
     * 绘图库测试方法
     */
    public static void stdDrawTest() {
    	StdDraw.setScale(-1, 1);
        StdDraw.clear(StdDraw.BLACK);
        
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.square(0, 0, 1);
        
        // write some text
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(0, +0.95, "Hello, world! This is a test Java program.");
        // StdDraw.text(0, -0.95, "Close this window to finish the installation.");
        
        // draw the bullseye
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(0, 0, 0.9);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, 0, 0.8);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        StdDraw.filledCircle(0, 0, 0.7);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(0, 0, 0.6);

        // draw a picture of the textbook      
        StdDraw.picture(0, 0, "cover.jpg", 0.65, 0.80);
    }
}
