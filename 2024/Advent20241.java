package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Advent20241 {
    private static String path = "C:\\Users\\user\\OneDrive\\PropCprog\\AdventOfCode\\2025\\";
    public static void main(String[] args) {
        PriorityQueue<Integer> list1 = new PriorityQueue<>();
        PriorityQueue<Integer> list2 = new PriorityQueue<>();
        populateLists(list1, list2);
        System.out.println("total distance: " + getTotalDistance(list1, list2));
        System.out.println("Similarity score: " + getSimilarityScore(list1, list2));
        
    }
    
    public static int getTotalDistance(PriorityQueue<Integer> list1, PriorityQueue<Integer> list2) {
        PriorityQueue<Integer> list1copy = new PriorityQueue<>(list1);
        PriorityQueue<Integer> list2copy = new PriorityQueue<>(list2);

        int size = list1copy.size();
        int totalDistance = 0;
        for (int i = 0; i < size; i++) {
            totalDistance += Math.abs(list1copy.poll() - list2copy.poll());
        }
        return totalDistance;
    }

    public static int getSimilarityScore(PriorityQueue<Integer> list1, PriorityQueue<Integer> list2) {
        PriorityQueue<Integer> list1copy = new PriorityQueue<>(list1);
        PriorityQueue<Integer> list2copy = new PriorityQueue<>(list2);

        int size = list1copy.size();
        int totalSimilarity = 0;
        for (int i = 0; i < size; i++) {
            int num = list1copy.poll();
            int count = 0;
            for (Integer n : list2copy) {
                if (n == num) {
                    count++;
                }
            }
            totalSimilarity += num * count;
        }
        return totalSimilarity;
    }

    public static void populateLists(PriorityQueue<Integer> list1, PriorityQueue<Integer> list2) {
        try (Scanner sc = new Scanner(new File(path + "input.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                // Split on tab or multiple spaces
                String[] parts = line.split("\\s+");

                list1.add(Integer.parseInt(parts[0])); 
                list2.add(Integer.parseInt(parts[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found!");
        }
    }
}
