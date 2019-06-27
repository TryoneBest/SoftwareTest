package com.homework.triangle;

import java.util.Scanner;

public class triangle{
    private float a, b, c;
    triangle(float a, float b, float c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String isTriangle(){
        if(this.a + this.b > this.c && this.a + this.c > this.b && this.b + this.c > this.a){
            if(this.a == this.b){
                if(this.a == this.c){
                    return "it's an equilateral triangle";
                }else {
                    return "it's an isosceles triangle";
                }
            } else{
                if(this.c == this.b){
                    return "it's an isosceles triangle";
                }else{
                    return "it's a scalene triangle";
                }
            }
        }else {
            return "it's not a triangle";
        }
    }
    public static void main(String []args){
        Scanner sc = null;
        String stop_tag = "c";
        float a, b, c;
        try {
            sc = new Scanner(System.in);
            System.out.println("Please input three sides of tht triangle divided with space:");
            a = sc.nextFloat();
            b = sc.nextFloat();
            c = sc.nextFloat();
            triangle triangle_entity = new triangle(a, b, c);
            System.out.println(triangle_entity.isTriangle());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sc != null){
                sc.close();
                sc = null;
            }
        }
    }
}