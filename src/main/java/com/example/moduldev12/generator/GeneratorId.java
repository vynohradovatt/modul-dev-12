package com.example.moduldev12.generator;

import java.util.Random;

public class GeneratorId {

    public long generateRandomId() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
