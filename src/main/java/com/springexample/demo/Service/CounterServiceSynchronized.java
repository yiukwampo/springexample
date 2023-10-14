package com.springexample.demo.Service;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceSynchronized {

    private int count;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }

    public int getCount() {
        synchronized(this) {
            return count;
        }
    }

}