package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/library-fine
 */
public class LibraryFine {

    private static final Integer DAY_FINE = 15;
    private static final Integer MONTH_FINE = 500;
    private static final Integer YEAR_FINE = 10000;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int dA, dE, mA, mE, yA, yE;

        boolean yearFine = false;
        boolean monthFine = false;
        boolean dayFine = false;
        boolean noFine = false;

        dA = in.nextInt();
        mA = in.nextInt();
        yA = in.nextInt();
        dE = in.nextInt();
        mE = in.nextInt();
        yE = in.nextInt();

        if (yA - yE > 0) {
            yearFine = true;
            System.out.println(YEAR_FINE);
        } else if (yA - yE < 0) {
            noFine = true;
        }

        if (mA - mE > 0 && !yearFine && !noFine) {
            monthFine = true;
            Integer monthDiff = mA - mE;
            System.out.println(monthDiff * MONTH_FINE);
        } else if (mA - mE < 0) {
            noFine = true;
        }

        if (dA - dE > 0 && !yearFine && !monthFine && !noFine) {
            dayFine = true;
            Integer dayDiff = dA - dE;
            System.out.println(dayDiff * DAY_FINE);
        }

        if (!yearFine && !monthFine && !dayFine) {
            System.out.println(0);
        }
    }
}
