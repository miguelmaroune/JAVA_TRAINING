package com.company.SharedC;

public class SharedClass {
    private volatile int x = 0;
    private volatile int y = 0;

    public void increment() {
        x++;
        y++;
    }

    public void checkForDataRace() {
        if (y > x) {
            System.out.println("y > x - Data Race is detected");
        }
    }
}

//
//    SharedClass sharedClass = new SharedClass();
//    Thread thread1 = new Thread(() -> {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            sharedClass.increment();
//        }
//    });
//
//    Thread thread2 = new Thread(() -> {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            sharedClass.checkForDataRace();
//        }
//
//    });
//
//        thread1.start();
//                thread2.start();