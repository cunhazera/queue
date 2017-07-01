package com.queue.app;

import com.queue.domain.ArrayQueue;
import com.queue.domain.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {

    private static Queue<Integer> queue = new ArrayQueue<>();

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RequestMapping("/enqueue")
    public Queue<Integer> enqueue(@RequestParam("num") Integer num) {
        queue.enqueue(num);
        return queue;
    }

    @RequestMapping("/queue")
    public Queue<Integer> queue() {
        return queue;
    }

    @RequestMapping("/dequeue")
    public Queue<Integer> dequeue() {
        queue.dequeue();
        return queue;
    }

    @RequestMapping("/front")
    public Integer front() {
        return queue.front();
    }

}
