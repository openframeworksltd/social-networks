package co.uk.openframeworks.util;

import co.uk.openframeworks.Circles;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Loads gplus circle from data file
 */
public class CircleLoader {

    public static void loadCircle(Circles circles, String fileName) {
        Set<String> seenStrings = new HashSet<String>();
        Set<String> seenIntegers = new HashSet<String>();
        Set<String> content = new HashSet<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // iterate over the file, adding new
        // string as circle name and the collect the integers as circles
        if (scanner != null) {
            while (scanner.hasNext("([A-Z])\\w+")) {
                String nextString = scanner.next("([A-Z])\\w+");
                if (!seenStrings.contains(nextString)) {
                    circles.addCircleName(nextString);
                    seenStrings.add(nextString);
                }
                while (scanner.hasNext("([0-9])\\d+")) {
                    String nextInt = scanner.next("([0-9])\\d+");
                    if (!seenIntegers.contains(nextInt)) {
                        content.add(nextInt);
                        seenIntegers.add(nextInt);
                    }
                }
                circles.addCircles(nextString, content);
            }
            scanner.close();
        }
    }
}
