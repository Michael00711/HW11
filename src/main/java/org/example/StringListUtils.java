package org.example;
import java.util.*;


public class StringListUtils {
    public static Map<String, Integer> countLetters(List<String> strings) {
        Map<String, Integer> resultMap = new HashMap<>();

        for (String str : strings) {
            resultMap.put(str, str.length());
        }

        return resultMap;
    }

    public static Map<Integer, List<String>> groupByLength(List<String> strings) {
        Map<Integer, List<String>> resultMap = new HashMap<>();

        for (String str : strings) {
            int length = str.length();
            resultMap.computeIfAbsent(length, k -> new ArrayList<>()).add(str);
        }

        return resultMap;
    }

    public static void addElementsAndMeasureTime() {
        long startTime, endTime;

        startTime = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken to add elements to ArrayList: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken to add elements to LinkedList: " + (endTime - startTime) + " nanoseconds");

        Random random = new Random();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            List<Integer> list = random.nextBoolean() ? arrayList : linkedList;
            int index = random.nextInt(list.size());
            Integer element = list.get(index);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken to get random elements: " + (endTime - startTime) + " nanoseconds");
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("тут", "там", "стол");

        System.out.println("Task1:");
        Map<String, Integer> letterCountMap = countLetters(strings);
        System.out.println(letterCountMap);

        System.out.println("\nTask2:");
        Map<Integer, List<String>> lengthGroupMap = groupByLength(strings);
        System.out.println(lengthGroupMap);

        System.out.println("\nTask3:");
        addElementsAndMeasureTime();
    }
}
