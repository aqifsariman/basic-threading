package sdf.ibf;

public class MyRunnableImplementation implements Runnable {

    private String taskName;

    public MyRunnableImplementation() {
    }

    public MyRunnableImplementation(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t\tRunnable ..." +
                    i);
        }

        // int i = 0;
        // while (i < 10) {
        // System.out.println(Thread.currentThread().getName() + "\t\tRunnable ..." +
        // i);
        // i++;
        // }

    }
}
