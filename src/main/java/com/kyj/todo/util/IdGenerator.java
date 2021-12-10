package com.kyj.todo.util;

public class IdGenerator {
    private final SequenceGenerator sequenceGenerator;

    private static final int TOTAL_BITS = 63;
    private static final int TIME_BITS = 42;
    private static final int SEQUENCE_BITS = TOTAL_BITS - TIME_BITS;

    private static final long EPOCH_SALT_MILLIS = 817430400000L;

    private IdGenerator() {
        sequenceGenerator = new SequenceGenerator(SEQUENCE_BITS);
    }

    private static class LazySingletonHolder {
        private static final IdGenerator INSTANCE = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return LazySingletonHolder.INSTANCE;
    }

    public long generate() {
        long now = System.currentTimeMillis();
        long time = now - EPOCH_SALT_MILLIS;
        long sequence = sequenceGenerator.generate();
        return time << SEQUENCE_BITS | sequence;
    }

    public static long extractTime(long id) {
        return (id >> SEQUENCE_BITS) + EPOCH_SALT_MILLIS;
    }
}
