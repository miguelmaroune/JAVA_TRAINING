package com.company.Atomic;

public class Metrics {
    private long count = 0;
    private volatile double average = 0.0;

    public synchronized void addSample(long sample) {
        double currentSum = average * count;
        count++;
        average = (currentSum + sample) / count;
    }

    public double getAverage() {
        return average;
    }
}

//    Metrics metrics = new Metrics();
//
//    BusinessLogic businessLogicThread1 = new BusinessLogic(metrics);
//
//    BusinessLogic businessLogicThread2 = new BusinessLogic(metrics);
//
//    MetricsPrinter metricsPrinter = new MetricsPrinter(metrics);
//
//        businessLogicThread1.start();
//                businessLogicThread2.start();
//                metricsPrinter.start();
