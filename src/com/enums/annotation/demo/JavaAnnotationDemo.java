package com.enums.annotation.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Annotation 注释
 * @author Cherry
 * 2020年4月20日
 */
public class JavaAnnotationDemo {

    public static void main(String[] args) {
        try {
            //通过反射获取注解信息
            Show show = Demo.class.getMethod("show").getAnnotation(Show.class);
            
            String key = show.key();
            int code = show.code();
            String[] values = show.values();
            String UUID = show.UUID();
            
            System.out.printf("key:%s, code:%d ,values:%s , UUID:%s",key,code,String.join("", Arrays.asList(values)),UUID);
        
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
//自定义注释
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@interface Show{
    String key();
    int code();
    String[] values();
    String UUID() default "abcdefg" ;
}
class Demo{
    @Show(key = "key",code = 10,values = {"A","B"})
    public void show() {
        System.out.println("SHOW");
    }
}