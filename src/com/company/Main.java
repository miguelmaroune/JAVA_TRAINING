package com.company;

import com.company.Atomic.BusinessLogic;
import com.company.Atomic.Metrics;
import com.company.Atomic.MetricsPrinter;
import com.company.DeadLock.Intersection;
import com.company.DeadLock.TrainA;
import com.company.DeadLock.TrainB;
import com.company.ECommerce.SharingResource;
import com.company.SharedC.SharedClass;
import com.company.WordCount.ThroughputHttpServer;
import com.company.images.PixelColor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {


        Intersection intersection = new Intersection();
        Thread trainAThread = new Thread(new TrainA(intersection));
        Thread trainBThread = new Thread(new TrainB(intersection));

        trainAThread.start();
        trainBThread.start();
    }
}
