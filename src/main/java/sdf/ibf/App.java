package sdf.ibf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

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

        // thread1.start();
        MyRunnableImplementation mRI = new MyRunnableImplementation("Task 1: ");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("Task 2: ");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("Task 3: ");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("Task 4: ");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("Task 5: ");
        // Thread thread2 = new Thread(mRI);
        // thread2.start();
        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        // EXECUTE ONE THREAD AT A TIME.
        // GOES TO NEXT THREAD WAS PREVIOUS THREAD IS COMPLETED.
        // ASYNCHRONOUS
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.shutdown();

        // SYNCHRONOUS TILL END OF THREAD LIMIT
        // EXAMPLE FIXED POOL IS 3. IF EXECUTING 5 TASKS ONLY AFTER 3 THREADS HAVE
        // COMPLETED ITS TASK
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown();

        // SYNCHRONOUS
        // WILL CREATE THE NUMBER OF THREADS NEEDED TO RUN THE TASKS
        // 5 TASKS WILL CREATE 5 THREADS
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(mRI);
        executorService.execute(mRI2);
        executorService.execute(mRI3);
        executorService.execute(mRI4);
        executorService.execute(mRI5);
        executorService.shutdown();

        // LAMBDA OPERATIONS
        MyMessageInterface printString = (a) -> System.out.println(a);
        MyRunnableInterface<Integer> addOperation = (a, b) -> a + b;
        MyRunnableInterface<Integer> multiplyOperation = (a, b) -> a * b;
        MyRunnableInterface<Integer> subtractOperation = (a, b) -> a - b;
        MyRunnableInterface<String> conCatOperation = (a, b) -> a + b;
        System.out.printf("Add Operation: %d\n", addOperation.process(1, 1));
        System.out.printf("Multiply Operation: %d\n", multiplyOperation.process(2, 5));
        System.out.printf("Subtract Operation: %d\n", subtractOperation.process(10, 2));
        System.out.printf("Concatenation Operation: %s\n", conCatOperation.process("Lorem", " Ipsum"));
        printString.printMessage("Take a break at 12pm.");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "The", "Rock", 5000));
        employees.add(new Employee(2, "John", "Cena", 4000));
        employees.add(new Employee(3, "Brock", "Lesnar", 12000));
        employees.add(new Employee(4, "The", "Undertaker", 8000));

        List<Employee> filteredEmployees = employees.stream().filter(emp -> emp.getFirstName().contains("The"))
                .collect(Collectors.toList());
        employees.forEach(employee -> System.out.println(employee));

        // employees.sort(Comparator.comparing(e -> e.getFirstName()));
        // employees.sort(Comparator.comparing(Employee::getFirstName).reversed());

        Comparator<Employee> compare = Comparator.comparing(e -> e.getFirstName());
        employees.sort(compare.reversed());

        // filteredEmployees.forEach(employee -> System.out.println(employee));

        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName);
        employees.sort(groupByComparator);
        employees.forEach(employee -> System.out.println(employee));

    }

}
