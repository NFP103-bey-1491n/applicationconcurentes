/*
 * Copyright © <Pascal Fares @ ISSAE - Cnam Liban>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package pairimpaire;

import java.sql.Time;
import java.util.Date;

class Paire extends Thread {
    @Override
    public void run () {
        for (int i=0; i< 10000; i++) {
            if (i%2==0) {
                System.out.printf("Thread paire %d\n", i);
            }
        }
    }
}

class Impaire implements Runnable {
    @Override
    public void run () {
        for (int i=0; i< 10000; i++) {
            if (i%2==1) {
                System.out.printf("Thread impaire %d\n", i);
            }
        }
    }
}

/**
 *
 * @author pascalfares
 */
public class PairImpaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Paire();
        Runnable r= new Impaire();
        Thread t2 = new Thread(r);
        
        t1.run();
        r.run();
        System.out.printf("\n-----------------------\n");
        t1.start();
        t2.start();
        
        t1.run();
    }
    
}