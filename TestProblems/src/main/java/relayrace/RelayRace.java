package relayrace;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Kunal on 4/30/2016.
 */
public class RelayRace implements IRelayRace {
    CountDownLatch latch = new CountDownLatch(1);
    private static final Integer NUM_TEAMS = 6;

    public void startRace() {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        //Intialize teams
        for (int i = 1; i <= NUM_TEAMS; i++) {
            Runnable worker = new RelayTeam("Team " + i, latch);
            executor.execute(worker);
        }
        //Set countdown to 0 and start all threads at the same time
        System.out.println("Starting race");
        latch.countDown();
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }

    public static void main(String[] args) {
        RelayRace race = new RelayRace();
        race.startRace();
    }

    /**************** Sample Output *********************
     *
     Starting race
     1st Team 3 - 37.730000000000004 seconds
     2nd Team 6 - 37.908 seconds
     3rd Team 4 - 38.053000000000004 seconds
     4th Team 5 - 38.924 seconds
     5th Team 1 - 40.304 seconds
     6th Team 2 - 40.418000000000006 seconds
     Finished all threads
     *
     * */
}
