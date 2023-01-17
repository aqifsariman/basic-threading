package sdf.ibf;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int j = 0; j < 20; j++) {
                    System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + j);
                }
            }
        });

        thread1.start();
        MyRunnableImplementation mRI = new MyRunnableImplementation();
        Thread thread2 = new Thread(mRI);
        thread2.start();

    }
}
