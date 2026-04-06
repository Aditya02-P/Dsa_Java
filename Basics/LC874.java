import java.util.HashSet;
import java.util.Set;

public class LC874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 1. Direction mapping: North, East, South, West
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int currentDir = 0; // Starts facing North (index 0)

        // 2. Load obstacles into a HashSet for O(1) instant lookups
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int x = 0;
        int y = 0;
        int maxDistSquared = 0;

        // 3. Process commands
        for (int command : commands) {
            if (command == -1) {
                // Turn right: clockwise shift
                currentDir = (currentDir + 1) % 4;
            } else if (command == -2) {
                // Turn left: counter-clockwise shift
                currentDir = (currentDir + 3) % 4;
            } else {
                // Move forward 'command' times
                for (int step = 0; step < command; step++) {
                    int nextX = x + dirs[currentDir][0];
                    int nextY = y + dirs[currentDir][1];

                    // Check if the next step hits an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // Stop moving forward for this command
                    }

                    // Update position if no obstacle
                    x = nextX;
                    y = nextY;

                    // Calculate and update max distance squared
                    // We check this every step, not just at the end of a command
                    int distSquared = x * x + y * y;
                    maxDistSquared = Math.max(maxDistSquared, distSquared);
                }
            }
        }

        return maxDistSquared;
    }

    public static void main(String[] args) {
        LC874 solution = new LC874();
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(solution.robotSim(commands, obstacles)); // Expected output: 65
    }
}