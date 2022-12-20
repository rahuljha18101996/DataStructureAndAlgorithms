package threading;

/*
 * CONCURRENCY
 * Pre-OS Era ~ Computers ran a single program
 *              > Used all scarce system resources - Very Inefficient
 * OS ~ Allowed multiple processes to run concurrently
 *      > Process ~ Gets own memory,file handles, etc.
 *      > Concurrency is achieved through multitasking
 *      > Multitasking ~ Switching CPU from process to another
 *      > Multitasking doesn't imply parallelism
 *      > Fast Switching ~ Illusion of parallelism
 *      > Concurrency ~ Better resource utilization
 *
 * Thread
 *   > Single sequential flow of control within a process.
 *   > A lightweight process
 *   > A process can have multiple threads
 *   > Thread share process-wide resource.
 *   > Each thread has its own PC, stack and local variables
 *   > java.lang.Thread
 *   > In laymen terms represent worker
 *   > Runnable is an interface which represent work
 *   > Cannot restart the thread again
 *
 * Thread States
 *   > New > Runnable > Running > Blocked > Dead/Terminated
 *
 * Thread Benefits
 *   > Exploiting  multiple processors
 *   > Allowed loosely couple designs
 *   > Better throughput even in single CPU machines
 *
 * Types of thread
 *   > Daemon Threads : Backgrounds threads for tasks such as Garbage Collector
 *   > Non-Daemon Threads
 *       : Created within application
 *       : main thread: created by JVM to run main()
 *       : JVM will not terminate if at least one non-daemon thread is running
 *
 * Thread Scheduler
 *   > Schedule the thread
 *   > Switch the thread accordingly
 *   > If some thread is in running its call stack will be active
 *   > Makes decision who run and how long they run
 *   > ***** No guarantee ~ Never rely on scheduler behaviour *****
 *
 * */

import java.util.concurrent.TimeUnit;

public class ThreadDemo {
    public static void DoTask(String taskName, int threadPriority) {
        Runnable task = new ThreadTask(threadPriority);
        Thread thread = new Thread(task);
        thread.setName(taskName);
        thread.setPriority(threadPriority);
        thread.start();
    }
}

class ThreadTask implements Runnable {

    private int t1,t2,t3;

    public ThreadTask(int p) {
        if (p == Thread.MAX_PRIORITY) {
            t1 = 100;
            t2 = 50;
            t3 = 50;
        }else if (p == Thread.MIN_PRIORITY) {
            t1 = 1;
            t2 = 3;
            t3 = 2;
        }else {
            t1 = 2;
            t2 = 2;
            t3 = 2;
        }
    }

    private static void sleepProcess(int timeInSeconds) {
        try {
            System.out.printf("Thread %s : Waiting for %d Seconds\n", Thread.currentThread().getName(),timeInSeconds);
            TimeUnit.SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        sleepProcess(t1);
        System.out.printf("Thread %s : Method Run\n", Thread.currentThread().getName());
        next();
    }

    private void next() {
        sleepProcess(t2);
        System.out.printf("Thread %s : Method Next\n", Thread.currentThread().getName());
        furtherNext();
    }

    private void furtherNext() {
        sleepProcess(t3);
        System.out.printf("Thread %s : Method Further Next\n", Thread.currentThread().getName());
    }
}

/*
 *
 * */
class ThreadTaskUsingThreadClass extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("This is another way......");
    }
}
