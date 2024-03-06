package com.albert.taskmanager.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {
    public UUID newUUID(){
        return UUID.randomUUID();
    }
}
