package com.kyj.todo.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class IdGeneratorTests {

    @DisplayName("아이디 생성 테스트")
    @Test
    public void generate_test() {
        long id = IdGenerator.getInstance().generate();
        long time = IdGenerator.extractTime(id);
        LocalDateTime dateTime = Instant.ofEpochMilli(time)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        log.info("generated id: {}", id);
        log.info("time of id: {}", time);
        log.info("date of time: {}", dateTime);
    }

    @DisplayName("아이디 멀티 스레드 생성 테스트")
    @Test
    public void generate_multi_thread_test() throws InterruptedException {
        int numberOfThreads = 1000;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        List<Long> ids = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < numberOfThreads; i++) {
            service.execute(() -> {
                long id = IdGenerator.getInstance().generate();
                log.info("generated id: {}", id);
                ids.add(id);
                latch.countDown();
            });
        }
        latch.await();

        List<Long> distinctIds = ids.stream().distinct().collect(Collectors.toList());
        Assertions.assertEquals(numberOfThreads, distinctIds.size());
    }


}
