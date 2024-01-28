package com.mysite.sbb;

import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class HelloLombok {
    private final String hello;
    private final int lombok;

    private String hello2;
    private int lombok2;
    
    // 생성자
//    public HelloLombok(String hello, int lombok) {
//        this.hello = hello;
//        this.lombok = lombok;
//    }

    // 멤버 변수에 대한 getter, setter 메소드 만들기
    public static void main(String[] args) {
        // RequiredArgsConstructor 롬복 생성자로 생성한 setter
        HelloLombok helloLombok = new HelloLombok("헬로", 1);
        // 롬복으로 생성한 setter
        helloLombok.setHello2("헬로2");
        helloLombok.setLombok2(2);

        // RequiredArgsConstructor 롬복 생성자로 생성한 getter
        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
        // 롬복으로 생성한 getter
        System.out.println(helloLombok.getHello2());
        System.out.println(helloLombok.getLombok2());

    }



}


