package com.websocket.springwebsocket.service;

import com.websocket.springwebsocket.model.Event;
import reactor.core.publisher.Flux;

public interface EventUnicastService {

    void onNext(Event next);

    Flux<Event> getMessages();
}
