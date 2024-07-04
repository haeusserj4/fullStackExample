package com.example.backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Counter {
    
    @Id
    private long id;
    private long counter;

    public Counter(){}

    public Counter(long id, long counter) {
        this.id = id;
        this.counter = counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }
}
