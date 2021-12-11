package com.company;

import lombok.Data;

import java.math.BigInteger;

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


}
