package com.queue.api;

import com.queue.domain.ArrayQueue;
import com.queue.domain.Queue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class QueueResource {

    private static Queue<Integer> queue;

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
