package com.enums.annotation.demo;
/**
 * Enum
 * @author Cherry
 * 2020年4月20日
 */
public class JavaEnumsDemo {

    public static void main(String[] args) {
        //enumCityShow();
        enumMethodShow();
    }
    public static void enumCityShow() {
        for (City c : City.values()) {
            c.getName();
            c.getCode();
            System.out.println(c);
        }
    }
    //枚举类实现接口
    public static void enumMethodShow() {
        EnumMedhod.SHOW.show();
        String h = EnumMedhod.SHOW.prin("Hello world !");
        System.out.println(h);
        
        EnumConstrutorMethod.SHOW.show();
    }
}
//City实际为继承了Enum的子类
enum City{
    BJ("BeiJin",0),SH("ShangHai",1),HZ("HangZhou",4);
    private String name;
    private int code;
    private City(String name , int code) {
        this.name = name;
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    public int getCode() {
        return this.code;
    }
    @Override
    public String toString() {
        return String.format("(%s,%d)",this.name,this.code);
    }
}
//特定值类本体(Value-Spacific Class Bodies) 自定义接口MethodForEnum
enum EnumMedhod implements MethodForEnum{
    SHOW{

        @Override
        public void show() {
            System.out.println("SHOW");
        }

        @Override
        public String prin(String str) {
            return str;
        }
        
    },TIME{

        @Override
        public void show() {
        }

        @Override
        public String prin(String str) {
            return null;
        }
       
    },NOW{

        @Override
        public void show() {
        }

        @Override
        public String prin(String str) {
            return null;
        }
       
    };
}
interface MethodForEnum{
    void show();
    String prin(String str);
}
//加入构造函数的特定值类本体
enum EnumConstrutorMethod implements MethodForEnum{
    SHOW("Cherry"){

        @Override
        public void show() {
            System.out.println(this.value);
        }

        @Override
        public String prin(String str) {
            return str;
        }
        
    };
    protected String value;
    private EnumConstrutorMethod(String v) {
        this.value = v;
    }
}