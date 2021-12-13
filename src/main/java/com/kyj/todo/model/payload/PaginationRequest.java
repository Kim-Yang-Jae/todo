package com.kyj.todo.model.payload;

import lombok.*;

@Getter
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
@ToString
public class PaginationRequest {
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int MIN_PAGE_SIZE = 5;
    private static final int MAX_PAGE_SIZE = 50;

    private static final long MIN_INDEX_VALUE = 0L;
    private static final long MAX_INDEX_VALUE = Long.MAX_VALUE;

    private long index;
    private int size;
    private boolean next;
    private boolean previous;

    public static PaginationRequest first() {
        return first(DEFAULT_PAGE_SIZE);
    }

    public static PaginationRequest first(int size) {
        return PaginationRequest.of(MIN_INDEX_VALUE, getRefinedSize(size), true, false);
    }

    public static PaginationRequest next(long index) {
        return next(index, DEFAULT_PAGE_SIZE);
    }

    public static PaginationRequest next(long index, int size) {
        return PaginationRequest.of(index, getRefinedSize(size), true, false);
    }

    public static PaginationRequest previous(long index) {
        return previous(index, DEFAULT_PAGE_SIZE);
    }

    public static PaginationRequest previous(long index, int size) {
        return PaginationRequest.of(index, getRefinedSize(size), false, true);
    }

    public static PaginationRequest last() {
        return last(DEFAULT_PAGE_SIZE);
    }

    public static PaginationRequest last(int size) {
        return PaginationRequest.of(MAX_INDEX_VALUE, getRefinedSize(size), false, true);
    }

    private static int getRefinedSize(int size) {
        return Math.max(MIN_PAGE_SIZE, Math.min(size, MAX_PAGE_SIZE));
    }
}
