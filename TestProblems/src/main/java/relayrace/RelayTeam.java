package relayrace;

import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Kunal on 4/30/2016.
 */
public class RelayTeam implements Runnable {

    private final CountDownLatch waitStart;
    private static final Integer NUM_RUNNERS = 4;
    private static final Integer SEC_TO_MILLIS = 1000;
    private String teamName;
    private static Integer teamPosition = 1;

    RelayTeam(String teamName, CountDownLatch waitStart) {
        this.teamName = teamName;
        this.waitStart = waitStart;
    }

    public void run() {

        DecimalFormat df = new DecimalFormat("#.###");
        Double timeTaken = 0.0;
        try {
            //Using CountDownLatch to ensure that all teams start at the same time
            waitStart.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted during awaiting countdown timer. Exiting...");
        }
        //Run loop for every runner. Sleep for time taken to complete runners leg of the race. Next runner starts when earlier one completes
        for (int i = 0; i < NUM_RUNNERS; i++) {
            Double legTime = Double.valueOf(df.format(ThreadLocalRandom.current().nextDouble(9.0, 10.5)));
            timeTaken = timeTaken + legTime;
            try {
                Thread.sleep((long) (legTime * SEC_TO_MILLIS));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted during sleep.");
            }
        }
        if (teamPosition == 1) {
            System.out.println(teamPosition + "st " + teamName + " - " + timeTaken + " seconds");
            teamPosition++;
        } else if (teamPosition == 2) {
            System.out.println(teamPosition + "nd " + teamName + " - " + timeTaken + " seconds");
            teamPosition++;
        } else if (teamPosition == 3) {
            System.out.println(teamPosition + "rd " + teamName + " - " + timeTaken + " seconds");
            teamPosition++;
        } else {
            System.out.println(teamPosition + "th " + teamName + " - " + timeTaken + " seconds");
            teamPosition++;
        }
    }
}
