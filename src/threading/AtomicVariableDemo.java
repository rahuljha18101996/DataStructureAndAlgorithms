package threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {
    public static void run() {
        MeetUpSimulator.MeetUpEvent jugBoston = new MeetUpSimulator.MeetUpEvent("Boston Java User Group");
        Thread user1 = new Thread(
                () -> {
                    jugBoston.attending(4);
                    System.out.printf("%s : %d\n",Thread.currentThread().getName(),jugBoston.get());
                }
        );

        Thread user2 = new Thread(
                () -> {
                    jugBoston.attending(3);
                    System.out.printf("%s : %d\n",Thread.currentThread().getName(),jugBoston.get());
                    jugBoston.notAttending(3);
                    System.out.printf("%s : %d\n",Thread.currentThread().getName(),jugBoston.get());
                }
        );

        Thread user3 = new Thread(
                () -> {
                    jugBoston.attending(1);
                    System.out.printf("%s : %d\n",Thread.currentThread().getName(),jugBoston.get());
                }
        );

        user1.setName("User 1");
        user2.setName("User 2");
        user3.setName("User 3");

        user1.start();
        sleep(1);
        user2.start();
        sleep(2);
        user3.start();
        sleep(2);

        System.out.printf("%s : %d\n",Thread.currentThread().getName(),jugBoston.get());
    }

    private  static void sleep(int timeInSecond) {
        //Thread.sleep(10000);
        try {
            TimeUnit.SECONDS.sleep(timeInSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MeetUpSimulator {
    public static  class MeetUpEvent {
        private String name;
        private AtomicInteger count = new AtomicInteger(1);
        //1 for organizer

        public MeetUpEvent(String name) {
            this.name = name;
        }
        public void attending(int guestCount) {
            if (guestCount == 1) {
                count.incrementAndGet();
            }else {
                count.addAndGet(guestCount);
            }
        }
        public void notAttending(int guestCount) {
            if (guestCount == 1) {
                count.decrementAndGet();
            }else  {
                boolean updated = false;
                while (!updated) {
                    int current = count.get();
                    int newCount = current - guestCount;
                    updated = count.compareAndSet(current,newCount);
                }
            }
        }
        public int get() {
            return count.get();
        }
    }
}
