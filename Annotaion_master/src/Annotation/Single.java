package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{
	int value(); // variable name must be value()
	int age() default 21; //this should be default because Single Member annotation present
}

public class Single {
	@MySingle(100) //Annotate a method using a singleMember annotation
	public static void myMeth() {
		Single ob = new Single();
		
		try {
			Class <?> c = ob.getClass();
			Method m = c.getMethod("myMeth");
			MySingle anno = m.getAnnotation(MySingle.class);
			System.out.println(anno.value());
			System.out.println( anno.age());
 		}catch(Throwable t) {
			
		}
	}
	public static void main(String[] args) {
		Single.myMeth();
	}
}
