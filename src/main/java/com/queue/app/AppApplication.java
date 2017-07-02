package com.queue.app;

import com.queue.domain.ArrayQueue;
import com.queue.domain.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@SpringBootApplication
@RestController
public class AppApplication {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RequestMapping("/init")
    public Collection<Integer> initialize(@RequestParam("size") Integer size) {
        queue = new ArrayQueue<>(size);
        return queue.values();
    }

    @RequestMapping("/enqueue")
    public Collection<Integer> enqueue(@RequestParam("num") Integer num) {
        queue.enqueue(num);
        return queue.values();
    }

    @RequestMapping("/dequeue")
    public Collection<Integer> dequeue() {
        queue.dequeue();
        return queue.values();
    }

    @RequestMapping("/front")
    public Integer front() {
        return queue.front();
    }

    @RequestMapping("/values")
    public Collection<Integer> values() {
        return queue.values();
    }

}
