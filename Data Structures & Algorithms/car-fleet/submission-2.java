class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // n rows, 2 columns
        // column 0 = position
        // column 1 = speed
        int[][] cars = new int[n][2];

        // Position aur speed ko cars matrix mein store karo
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Position ke according descending order mein sort
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleetCount = 0;
        double previousTime = 0;

        // Har car ko target ke closest se check karo
        for (int i = 0; i < cars.length; i++) {

            double currentTime =
                (double) (target - cars[i][0]) / cars[i][1];

            if (currentTime > previousTime) {
                fleetCount++;
                previousTime = currentTime;
            }
        }

        return fleetCount;
    }
}