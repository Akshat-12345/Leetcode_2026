import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (operations[i].equals("D")) {
                s.push(2 * s.peek());
            } else if (operations[i].equals("C")) {
                s.pop();
            } else if (operations[i].equals("+")) {
                int topVal = s.pop();
                int secondVal = s.peek();
                s.push(topVal);
                int newVal = topVal + secondVal;
                s.push(newVal);
            } else {
                s.push(Integer.parseInt(operations[i]));
            }
        }

        int totalSum = 0;
        for (int score : s) {
            totalSum += score;
        }
        
        return totalSum;
    }
}