package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Target(ElementType.TYPE_USE)
@interface TypeAnno{
	
}

@Target(ElementType.TYPE_USE)
@interface NotZeroLen{
	
}

@Target(ElementType.TYPE_USE)
@interface Unique{
	
}

@Target(ElementType.TYPE_USE)
@interface MaxLen{
	int value();
}

@Target(ElementType.TYPE_PARAMETER)
@interface Whatt{
	String description();
}

@Target(ElementType.FIELD)
@interface EmptyOK{
	
}

@Target(ElementType.METHOD)
@interface Recomended{
	
}

public class TypeAnnoDemo <@Whatt (description = "Generic Data Type") T>{
	public @Unique TypeAnnoDemo(){
		
	}
	
	@TypeAnno String str;
	
	@EmptyOK String test;
	
	public @TypeAnno Integer f2 (int j, int k) {
		return j*k;
	}
	
	public @Recomended Integer f3(String str) {
		return str.length()/2;
	}
	
	public void f4() throws @TypeAnno Throwable{
		
	}
	
	String @MaxLen(10) [] @NotZeroLen [] w;
	
	@TypeAnno Integer[] vec;
	
	public static void myMeth(int i) {
		TypeAnnoDemo<@TypeAnno Integer> ob = new TypeAnnoDemo<@TypeAnno Integer>();
		
		@Unique TypeAnnoDemo<Integer> ob2 = new @Unique TypeAnnoDemo<Integer>();
		
		Object x = Integer.valueOf(10);
		Integer y;
		
		y = (@TypeAnno Integer) x;
	}
	
	public static void main(String[] args) {
		myMeth(10);
	}
	
	class SomeClass extends @TypeAnno TypeAnnoDemo<Boolean>{
		
	}
	
}