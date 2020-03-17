package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;





@Retention(RetentionPolicy.RUNTIME)
@interface Annoten{
	String str();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What{
	String description();
}

@Annoten(str = "Hein", val = 20)
@What(description = "Good")

public class Meta3 {
	@Annoten(str = "Hein", val = 20)
	@What(description = "Bad")
	
	public static void call() {
		Meta3 ob = new Meta3();
		
		try {
			Annotation anno[] = ob.getClass().getAnnotations(); //getAnnotations() return an Array of annotation Object
			
			for(Annotation a : anno) { //Display all Annotation for Meta3
				System.out.println(a);
			}
			
			System.out.println();
			
			Class<?> c = ob.getClass();
			Method m = c.getMethod("call");
			anno = m.getAnnotations();
			
			for(Annotation a : anno) { //Display all Annotation for call()
				System.out.println(a);
			}
		}catch(Throwable t) {
			
		}
	}
	public static void main(String[] args) {
		Meta3.call();
	}
}
