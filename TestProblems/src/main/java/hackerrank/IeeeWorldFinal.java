package hackerrank;

import java.util.Scanner;

/**
 * Created by Kunal on 12/3/2016.
 */
public class IeeeWorldFinal {

    /*
    * 4 5
    * 10101
    * 11100
    * 11010
    * 11010
    * */
    public static void main(String args[]) throws Exception {

        Scanner in = new Scanner(System.in);
        int numTeams = in.nextInt();
        int numTopics = in.nextInt();

        int maxKnownTopics = 0;
        int numTeamsWithMaxTopics = 0;
        String[] topicsKnownPerTeam = new String[numTeams];

        //Read from scanner and save in an array of strings
        for (int i = 0; i < numTeams; i++) {
            topicsKnownPerTeam[i] = in.next();
        }

        //Merging the topics known of two teams
        for (int i = 0; i < topicsKnownPerTeam.length; i++) {
            for (int j = i + 1; j < topicsKnownPerTeam.length; j++) {
                int currKnownTopics = 0;
                for (int k = 0; k < numTopics; k++) {
                    //If either is set to 1, increment number of topics currently known
                    if (topicsKnownPerTeam[i].charAt(k) == '1' || topicsKnownPerTeam[j].charAt(k) == '1') {
                        currKnownTopics++;
                    }
                }
                //If currently known topics greater than current max known topics,
                // replace the max known topics number with currently known topics number
                if (currKnownTopics > maxKnownTopics) {
                    maxKnownTopics = currKnownTopics;
                    numTeamsWithMaxTopics = 1;
                    //if another pair of teams knows same number of topics as max known topics, increment number of teams
                } else if (currKnownTopics == maxKnownTopics) {
                    numTeamsWithMaxTopics++;
                }
            }
        }
        System.out.println(maxKnownTopics);
        System.out.println(numTeamsWithMaxTopics);
    }

}
