package hackerrank;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kunal on 12/3/2016.
 */
public class PrintDomains {


    static void printDomains(String[] arr) {

        if (arr == null) {
            return;
        }

        final Pattern pattern = Pattern.compile("https?://(www.|ww2.|web.)?([a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+)");
        Set<String> domainNames = new TreeSet<>();

        for (String s : arr) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                String domainName = matcher.group(2);
                domainNames.add(domainName);
            }
        }

        StringBuilder output = new StringBuilder();
        String separator = "";
        for (String domainName : domainNames) {
            output.append(separator);
            separator = ";";
            output.append(domainName);
        }
        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        printDomains(null);
    }

}
