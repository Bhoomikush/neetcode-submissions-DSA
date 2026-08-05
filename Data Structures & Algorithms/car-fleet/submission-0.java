

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store position and time
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        // Sort by position (largest to smallest)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            double time = cars[i][1];

            // New fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}