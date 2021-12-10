package com.kyj.todo.model.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class B {
    private final String a;

    private final String b;

    private final String c;

    private final String d;
}
