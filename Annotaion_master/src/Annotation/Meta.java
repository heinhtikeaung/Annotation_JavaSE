/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Annotation;

/**
 *
 * @author DELL
 */
import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int val();
}

public class Meta {
    @MyAnno(str = "Annotation", val = 100)
    public static void myMeth() {
    	Meta ob = new Meta();
    	
    	try {
    		Class <?> c = ob.getClass();
    		Method m = c.getMethod("myMeth");
    		MyAnno anno = m.getAnnotation(MyAnno.class);
    		System.out.println(anno.str() + " " + anno.val());
    	}catch(Throwable t) {
    		
    	}
    }
    
    public static void main(String[] args) {
		myMeth();
	}
}

