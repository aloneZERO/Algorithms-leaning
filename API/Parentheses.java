package com.leo.api;

import java.util.Scanner;

import com.leo.api.collection.LinkedListStack;

public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';
    
    /**
     * 判断括号是否配对
     * @param s
     * @return
     */
    public static boolean isBalanced(String s) {
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
            if(s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
            if(s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);
            if(s.charAt(i) == RIGHT_PAREN) {
                if(stack.isEmpty())           return false;
                if(stack.pop() != LEFT_PAREN) return false;
            }
            else if(s.charAt(i) == RIGHT_BRACE) {
                if(stack.isEmpty())           return false;
                if(stack.pop() != LEFT_BRACE) return false;
            }
            else if(s.charAt(i) == RIGHT_BRACKET) {
                if(stack.isEmpty())             return false;
                if(stack.pop() != LEFT_BRACKET) return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isBalanced(s));
        in.close();
    }
}
