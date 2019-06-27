package com.homework.triangle; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* triangle Tester. 
* 
* @author <RenheXu>
* @since <pre>六月 27, 2019</pre> 
* @version 1.0 
*/ 
public class triangleTest { 

@Before
public void before() throws Exception {
    System.out.println("before");
} 

@After
public void after() throws Exception {
    System.out.println("after");
} 

/** 
* 
* Method: isTriangle() 
* 
*/ 
@Test
public void testIsTriangle() throws Exception {
    System.out.println("边界值分析:");
    float[] a = {420, 0, 1, 3, 798, 800, 803, 411, 384, 406, 401, 396, 397, 396, 398, 387, 401, 413, 402};
    float[] b = {399, 395, 410, 399, 388, 379, 420, 0, 1, 3, 798, 800, 803, 401, 402, 394, 395, 399, 410};
    float[] c = {401, 400, 389, 399, 413, 394, 402, 387, 399, 396, 407, 410, 388, 0, 1, 3, 789, 800, 803};
    for(int i = 0; i < a.length; i++){
        triangle triangels = new triangle(a[i], b[i], c[i]);
        System.out.println("a=" + a[i] + ",b=" + b[i] + ",c=" + c[i] + "," + triangels.isTriangle());
    }
} 

/** 
* 
* Method: main(String []args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
