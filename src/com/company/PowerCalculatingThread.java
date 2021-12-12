package com.company;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class PowerCalculatingThread extends Thread{

    private BigInteger base ;
    private BigInteger power ;
    private BigInteger result = BigInteger.ONE;

    public PowerCalculatingThread (BigInteger base , BigInteger power)
    {
        this.base = base ;
        this.power = power;
    }
@Override
    public void run()
{ result = BigInteger.ONE;

    for(BigInteger i = BigInteger.ZERO;
        i.compareTo(power) !=0;
        i = i.add(BigInteger.ONE)) {
        result = result.multiply(base);
    }
}


public static void init() throws InterruptedException {
    List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);

    List<FactorialThread> threads = new ArrayList<>();

    for (long inputNumber : inputNumbers) {
        threads.add(new FactorialThread(inputNumber));
    }

    for (Thread thread : threads) {
        thread.setDaemon(true);
        thread.start();
    }

    for (Thread thread : threads) {
        //wait 2 seconds for all to finish
        thread.join(2000);
    }
//print the result after all the threads are done.
    for (int i = 0; i < inputNumbers.size(); i++) {
        FactorialThread factorialThread = threads.get(i);
        if (factorialThread.isFinished()) {
            System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
        } else {
            System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
        }
    }

}

}
