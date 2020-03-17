/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 *
 * @author DELL
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Anno{
    String name();
    int age();
}

public class Meta2 {
    @Anno(name = "Hein Htike Aung", age = 21)    
    
    public static void call(String str,int i, String s){
        Meta2 ob = new Meta2();
        try{
            Class <?> c = ob.getClass();
            Method m = c.getMethod("call", String.class, int.class, String.class);
            Anno ano = m.getAnnotation(Anno.class);
            
            System.out.println(ano.name() + " " + ano.age());
            System.out.println(str + " " + i + " " + s);
        }catch(Throwable t){
            
        }
    }
    public static void main(String[] args) {
        Meta2.call("Hello",10,"Hi");
    }
}
