package ait.elevator.task;

import ait.elevator.model.Elevator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Truck implements Runnable {
    private static Lock mutex = new ReentrantLock();
    private static Object monitor_0 = new Object();
    private static Object monitor_1 = new Object();
    private int nRaces;
    private int capacity;
    private Elevator elevators;

    public Truck(int nRaces, int capacity, Elevator elevators) {
        this.nRaces = nRaces;
        this.capacity = capacity;
        this.elevators = elevators;
    }

    @Override
    public void run() {
        for (int i = 0; i < nRaces; i++) {
            mutex.tryLock();
            mutex.lock();
            try {
                elevators.add(capacity);
            }finally {
                mutex.unlock();
            }

            mutex.unlock();
        }


    }
}


