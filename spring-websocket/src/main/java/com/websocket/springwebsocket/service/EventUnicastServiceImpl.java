package com.websocket.springwebsocket.service;

import com.websocket.springwebsocket.model.Event;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Service
public class EventUnicastServiceImpl implements EventUnicastService {

    private EmitterProcessor<Event> processor = EmitterProcessor.create();

    @Override
    public void onNext(Event next) {
        processor.onNext(next);
    }

    @Override
    public Flux<Event> getMessages() {
        return processor.publish().autoConnect();
    }
}
