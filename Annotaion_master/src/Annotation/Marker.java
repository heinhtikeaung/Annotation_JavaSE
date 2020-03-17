package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{
	
}

public class Marker {
	@MyMarker
	public static void myMeth() {
		Marker ob = new Marker();
		
		try {
			Class <?> c = ob.getClass();
			Method m = c.getMethod("myMeth");
			
			if(m.isAnnotationPresent(MyMarker.class)) { // check the Annotation is present
				System.out.println("Present");
			}
			else {
				System.out.println("Not Present");
			}
		}catch(Throwable t) {
			
		}
	}
	public static void main(String[] args) {
		Marker.myMeth();
	}
}
