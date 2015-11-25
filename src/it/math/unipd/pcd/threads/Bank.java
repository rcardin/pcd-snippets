/**
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2015 Riccardo Cardin
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * <p/>
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
package it.math.unipd.pcd.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Please, insert description here.
 *
 * @author Riccardo Cardin
 * @version 1.0
 * @since 1.0
 */
public class Bank {

    public static final int NUMBER_OF_ACCOUNT = 100;

    private double[] accounts = new double[NUMBER_OF_ACCOUNT];

    private Lock lock = new ReentrantLock();
    private Condition sufficientFunds;

    public Bank(double total) {
        double singleAmount = total / 100D;
        for (int i = 0; i < NUMBER_OF_ACCOUNT; i++) {
            accounts[i] = singleAmount;
        }
        sufficientFunds = lock.newCondition();
    }

    private double getAdditionalAmount(double amount) throws InterruptedException {
        Thread.sleep(1000);
        return amount * 0.04D;
    }

    public void transfer(int from, int to, double amount) {
        try {
            // Not synchronized operation
            double additionalAmount = getAdditionalAmount(amount);
            // Acquiring lock
            lock.lock();
            // Verifying condition
            while (amount + additionalAmount > accounts[from]) {
                sufficientFunds.await();
            }
            // Transferring funds
            accounts[from] -= amount + additionalAmount;
            accounts[to] += amount + additionalAmount;
            // Signaling that something has changed
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
                lock.unlock();
        }
    }

    public double getTotal() {
        double total = 0.0D;
        lock.lock();
        try {
            for (int i = 0; i < NUMBER_OF_ACCOUNT; i++) {
                total += accounts[i];
            }
        } finally {
            lock.unlock();
        }
        return total;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(100000D);

        for (int i = 0; i < 1000; i++) {
            new Thread(new TransferRunnable(bank)).start();
        }
    }
}

class TransferRunnable implements Runnable {

    private static final double MAX_TRANSFERABLE_AMOUNT = 1000D;

    private Bank bank;

    public TransferRunnable(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        int to = (int) (Math.random() * Bank.NUMBER_OF_ACCOUNT);
        int from = (int) (Math.random() * Bank.NUMBER_OF_ACCOUNT);
        double amount = Math.random() * MAX_TRANSFERABLE_AMOUNT;
        bank.transfer(from, to, amount);

        System.out.println(String.format("From %s To %s Amount %s Total %s",
                from, to, amount, bank.getTotal()));
    }
}






























