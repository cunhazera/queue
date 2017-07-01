package com.queue.api;

import com.queue.domain.LinkedQueue;
import com.queue.domain.Queue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueResource {

    private Queue<Integer> queue = new LinkedQueue<>();

    @RequestMapping("/queue")
    public Queue<Integer> queue() {
        return queue;
    }

}
