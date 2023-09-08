package com.gintophilip.asyncDemo.controller;

import com.gintophilip.asyncDemo.entities.RandomUUID;
import com.gintophilip.asyncDemo.service.RandomUUIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/")
public class AsyncController {
    @Autowired
    RandomUUIDService userService;
    @PostMapping("/execute")
    ResponseEntity<Long> timeConsumingTask(){
        Long taskId = new Random().nextLong(900) + 100;
        userService.timeConsumingTask(taskId);
        return ResponseEntity.ok(taskId);
    }
    @GetMapping("/fetch/{taskId}")
    ResponseEntity<Optional<RandomUUID>> fetchResult(@PathVariable Long taskId){
        return ResponseEntity.ok(userService.fetchResult(taskId));
    }
}
