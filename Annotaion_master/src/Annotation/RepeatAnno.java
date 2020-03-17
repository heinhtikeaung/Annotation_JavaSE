package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface Annota{
	String str() default "Hein";
	int val() default 21;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos{
	Annota[] value();
}

public class RepeatAnno {
	@Annota (str = "Firsts", val = 23)
	@Annota (str = "Second", val = 27) // Repeat Annotation
	public static void myMeth(String str, int i) {
		RepeatAnno ob = new RepeatAnno();
		try {
			Class <?> c = ob.getClass();
			Method m = c.getMethod("myMeth", String.class, int.class);
			Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
			
			System.out.println(anno);
			System.out.println(str + " " + i);
		}catch(Throwable t) {
			
		}
	}
	public static void main(String[] args) {
		myMeth("Aung Aung ", 100);
	}
}
