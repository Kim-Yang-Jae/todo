package com.kyj.todo.util;

public class SequenceGenerator {
    private long sequence;
    private final long maxSequence;

    public SequenceGenerator(int bitsSize) {
        this.sequence = 0;
        this.maxSequence = Double.valueOf(Math.pow(2, bitsSize)).longValue();
    }

    public synchronized long generate() {
        if (sequence >= maxSequence) {
            sequence = 0;
        }
        return sequence++;
    }
}
