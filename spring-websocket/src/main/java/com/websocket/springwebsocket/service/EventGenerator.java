package com.websocket.springwebsocket.service;

import com.websocket.springwebsocket.model.Event;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EventGenerator {

    private EventUnicastService eventUnicastService;

    public EventGenerator(EventUnicastService eventUnicastService) {
        this.eventUnicastService = eventUnicastService;
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 1000)
    public void generateEvent() {
        int count = getRandomNumberInRange(40000,60000);
        Event event = new Event("Bitcoin", count);
        eventUnicastService.onNext(event);
    }
    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

    }
}
