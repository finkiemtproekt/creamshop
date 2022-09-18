package com.ukim.mk.projectspring.model.events;

import com.ukim.mk.projectspring.model.Cream;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class ProductCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public ProductCreatedEvent(Cream source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public ProductCreatedEvent(Cream source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}

