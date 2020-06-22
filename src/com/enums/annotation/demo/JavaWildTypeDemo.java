package com.enums.annotation.demo;
/**
 * WildType 泛型
 * @author Cherry
 * 2020年4月20日
 */
public class JavaWildTypeDemo {

    public static void main(String[] args) {
        //将String转换成Music类型
        Music cm = apply("风云",(s) -> {
            return new Music(s);
        });
        System.out.println(cm);
        
        //使用extends的泛型
        var node = new Node<ChinaMusic>();
        node.t = new ChinaMusic("不再犹豫", 3); 
       System.out.println(musicToString(node).name);
    }
    
    //将T类型转换成R类型，R必须为Music的子类
    public static <T,R> R apply(T t,Fun<T,R> fun) {
        return fun.apply(t);
    }
    
    @SuppressWarnings("unchecked")
    public static <T extends Music> T musicToString(Node<? extends Music> node) {
        return (T) node.t;
    }
}
//泛型
@FunctionalInterface
interface Fun<T,R>{
    R apply(T t);
}
class Music{
    String name;
    public Music(String name) {
        super();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Music [name=" + name + "]";
    }
}
class ChinaMusic extends Music{
    int code;
    public ChinaMusic(String name,int code) {
        super(name);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return "ChinaMusic [code=" + code + "]";
    }
}
class Node<T>{
    T t;
    @Override
    public String toString() {
        return t.toString();
    }
}