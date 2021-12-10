package com.kyj.todo.model.payload;


import lombok.*;

@Getter
@Builder
@ToString
public class A {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public static A of(B b){
        return builder()
                .a(b.getA())
                .b(b.getB())
                .c(b.getC())
                .d(b.getD())
                .e("")
                .build();
    }
}
