package com.it.elec.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**被@Retention这个注解修饰的注解，利用反射，将其他的注解读取出来*/
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationPermission {

	String mid();
	String pid();
}
