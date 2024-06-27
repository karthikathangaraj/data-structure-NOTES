package algorithms;
import java.util.*;

public class FirstNonRepeatingCharacter {

    public static String findFirstNonRepeating(String A) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            queue.offer(ch);

            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                result.append("#");
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input stream A: ");
        String A = scanner.next();
        
        String result = findFirstNonRepeating(A);
        System.out.println("Output: " + result);
        
        scanner.close();
    }
}
