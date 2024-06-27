package algorithms;

import java.util.*;

public class GroupElementsByFirstOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        // Read the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Group elements by their first occurrence
        int[] groupedArr = groupElementsByFirstOccurrence(arr);

        // Print the result
        System.out.println("Grouped array:");
        System.out.println(Arrays.toString(groupedArr));

        scanner.close();
    }

    public static int[] groupElementsByFirstOccurrence(int[] arr) {
        // LinkedHashMap to maintain the order of first occurrence
        LinkedHashMap<Integer, Integer> firstOccurrence = new LinkedHashMap<>();

        // Traverse the array and record the first occurrence of each element
        for (int value : arr) {
            if (!firstOccurrence.containsKey(value)) {
                firstOccurrence.put(value, 1);
            } else {
                firstOccurrence.put(value, firstOccurrence.get(value) + 1);
            }
        }

        // Create a list to store the result
        List<Integer> resultList = new ArrayList<>();

        // Group the elements together in the result list
        for (Map.Entry<Integer, Integer> entry : firstOccurrence.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                resultList.add(element);
            }
        }

        // Convert the result list to an array
        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }
}