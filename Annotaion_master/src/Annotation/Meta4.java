package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)

@interface MyAn{
	String str() default "Hein";
	int val() default 22;
}

public class Meta4 {
	@MyAn
	public static void myMeth() {
		Meta4 ob = new Meta4();
		
		try {
			Class <?> c = ob.getClass();
			Method m = c.getMethod("myMeth");
			MyAn anno = m.getAnnotation(MyAn.class);
			System.out.println(anno.str() + " " + anno.val());
			
		}catch(Throwable t) {
			
		}
	}
	public static void main(String[] args) {
		Meta4.myMeth();
	}
}
