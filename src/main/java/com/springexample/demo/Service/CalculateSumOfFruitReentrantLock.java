package com.springexample.demo.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

@Service
public class CalculateSumOfFruitReentrantLock {

    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock();
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        int temp = 0;
        lock.lock();
        try {
            temp = count;
        } finally {
            lock.unlock();
        }
        return temp;
    }

}
