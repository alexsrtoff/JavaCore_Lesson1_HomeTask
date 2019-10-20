package Lesson5;

public class MainClass {
    static class MyThread extends Thread {
        static final int SIZE = 10000000;
        static final int HALF = SIZE / 2;

        public void part1(){
            float[] arr = new float[SIZE];
            for(int i = 0; i < arr.length; i++){
                arr[i] = 1;
            }
            long a = System.currentTimeMillis();
            for(int i = 0; i < SIZE; i++){
                arr[i] =(float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

            }
            System.out.println("Первый вариант: ");
            System.out.println(System.currentTimeMillis() - a);
        }

        public void part2(){

            float[] a1 = new float[HALF];
            float[] a2 = new float[HALF];
            float[] arr = new float[SIZE];

            for(int i = 0; i < SIZE; i++){
                arr[i] = 1;
            }

            long a = System.currentTimeMillis();

            Thread thread1 = new Thread(){
                public void run(){
                    System.arraycopy(arr, 0, a1, 0, HALF);
                    for (int i = 0; i < HALF; i++){
                        a1[i] =(float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                    System.arraycopy(a1, 0, arr, 0, HALF);
                }
            };
            Thread thread2 = new Thread(){

                public void run(){
                    System.arraycopy(arr, HALF, a2, 0, HALF);
                    for (int i = 0; i < HALF; i++){
                        a2[i] =(float)(a2[i] * Math.sin(0.2f + (HALF+i+1) / 5) * Math.cos(0.2f + (HALF+i+1) / 5) * Math.cos(0.4f + (HALF+i+1) / 2));
                    }
                    System.arraycopy(a2, 0, arr, HALF, HALF);
                    System.out.println(System.currentTimeMillis() - a);
                }
            };

            thread1.start();
            thread2.start();
            System.out.println("Второй вариант: ");
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.part1();
        thread1.part2();

    }

}
