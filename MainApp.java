package ru.gb.homework5;

import java.util.Arrays;

public class MainApp {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        methodOne();
        methodTwo();

        Thread t1 = new Thread(new RunnableMethodOne());
        t1.start();

        Thread t2 = new Thread(new RunnableMethodTwo());
        t2.start();


    }

    private static void methodOne() {
//        System.out.println("Hello from method One");
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
//            System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

        });
        thread.setName("Thread for method one");
        thread.start();

        try {
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Method one take " +
                + (System.currentTimeMillis() - start) + " ms");
        //System.out.println(Arrays.toString(arr));

    }

    private static void methodTwo() {
        //System.out.println("hello from method Two");
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        // разделяем массив
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr,HALF,arr2,0,HALF);

        Thread t1 = new Thread(() -> {
            Arrays.fill(arr1, 7.0f);
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            Arrays.fill(arr2, 2.0f);
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // склеиваем массивы
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2,0,arr,HALF,HALF);

        System.out.println("Method two take " + (System.currentTimeMillis() - start) + " ms");

    }

    static class RunnableMethodOne implements Runnable {

        @Override
        public void run() {
//            System.out.println("Hello from runnable One");
            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1.0f);
//            System.out.println(Arrays.toString(arr));
            long start = System.currentTimeMillis();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

            Thread.currentThread().setName("Runnable one thread");
            System.out.println(Thread.currentThread().getName() + " take "
                    + (System.currentTimeMillis() - start) + " ms");
        }
    }

    static class RunnableMethodTwo implements Runnable {

        @Override
        public void run() {
            float[] arr = new float[SIZE];
            Arrays.fill(arr, 1.0f);
            long start = System.currentTimeMillis();
            float[] arr1 = new float[HALF];
            float[] arr2 = new float[HALF];

            // разделяем массив
            System.arraycopy(arr, 0, arr1, 0, HALF);
            System.arraycopy(arr,HALF,arr2,0,HALF);

            Thread t1 = new Thread(() -> {
                Arrays.fill(arr1, 7.0f);
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            });

            Thread t2 = new Thread(() -> {
                Arrays.fill(arr2, 2.0f);
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // склеиваем массивы
            System.arraycopy(arr1, 0, arr, 0, HALF);
            System.arraycopy(arr2,0,arr,HALF,HALF);
            Thread.currentThread().setName("Runnable two thread");
            System.out.println(Thread.currentThread().getName() + " take " + (System.currentTimeMillis() - start) + " ms");
        }
    }
}


