package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Advent20252 {
    private static String path = "C:\\Users\\user\\OneDrive\\PropCprog\\AdventOfCode\\2025\\";
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (Scanner sc = new Scanner(new File(path + "input2.txt"))) {
            long result = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                // Split on commas
                String[] ranges = line.split(",");
                //for each range (got all numbers)
                for (String r : ranges) {
                    String[] nums = r.split("-");
                    long start = Long.parseLong(nums[0]);
                    long end = Long.parseLong(nums[1]);
                    //for each number
                    for (long i = start; i <= end; i++) {
                        String s = Long.toString(i);
                        //check for each division
                        for (int j = 2; j <= s.length(); j++) {
                            //if divisible
                            if (s.length() % j == 0) {
                                int chunkLen = s.length() / j;
                                int k = 1;
                                while (k < j && s.regionMatches(0, s, k * chunkLen, chunkLen)) {
                                    k++;
                                }
                                if (k == j) {
                                    //System.out.println(i + " is made of " + j + " repeats");
                                    result += i;
                                    break;
                                }
                            }
                        }
                    }
                } 
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found!");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + " ms");  
    }
}
