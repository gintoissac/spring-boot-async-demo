package com.gintophilip.asyncDemo.service;

import com.gintophilip.asyncDemo.entities.RandomUUID;
import com.gintophilip.asyncDemo.repositories.RandomUUIDRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RandomUUIDService {
    @Autowired
    RandomUUIDRepository randomUUIDRepository;
    Logger logger = LoggerFactory.getLogger(RandomUUIDService.class);
    @Async("asyncExecutor")
    public void timeConsumingTask(Long taskId) {
        logger.info("Thread name :{}",Thread.currentThread().getName());
        try {
            String id = String.valueOf(UUID.randomUUID());
            Thread.sleep(180000);
            RandomUUID uuid = new RandomUUID();
            uuid.setId(taskId);
            uuid.setUUID(id);
            randomUUIDRepository.save(uuid);
            logger.info("task completed");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<RandomUUID> fetchResult(Long taskId) {
        return randomUUIDRepository.findById(taskId);
    }
}
