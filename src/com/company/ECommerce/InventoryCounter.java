package com.company.ECommerce;

import java.util.concurrent.atomic.AtomicInteger;

public class InventoryCounter {//We dont need the syncronize key word because the items variable is atomic
    private AtomicInteger items = new AtomicInteger(0);

    public void increment() {
        items.incrementAndGet();
    }

    public void decrement() {
        items.decrementAndGet();
    }

    public int getItems() {
        return items.get();
    }
}
