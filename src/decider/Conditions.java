package decider;

/**
 * Conditions calculate if the given points fulfill
 * the specified conditions based on given parameters
 */
public class Conditions {

    int[][] points;
    Parameters params;

    public Conditions(int[][] points, Parameters parameters) {
        this.points = points;
        this.params = parameters;
    }

    public boolean licCond0() {
        int[] prevPoint;
        prevPoint = points[0];

        float xDis, yDis;

        if(points.length < 2)
            throw new IllegalArgumentException("Need to be at least two points");

        /**
         * Iterate each point and check the distance between two consecutive points
         */
        for(int[] point : points) {
            xDis = prevPoint[0] - point[0];
            yDis = prevPoint[1] - point[1];

            if(Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2)) > params.LENGTH1)
                return true;

            prevPoint = point;
        }

        return false;
    }
    public boolean licCond1() {
        return false;
    }
    public boolean licCond2() {
        return false;
    }
    public boolean licCond3() {
        return false;
    }
    public boolean licCond4() {
        return false;
    }
    public boolean licCond5() {
        return false;
    }
    public boolean licCond6() {

        if(points.length < 3)
           return false;

        int[] first;
        int[] last;

        double xDis, yDis;

        // Do this for all cases of K_PTS consecutive points
        for (int i = 0; i <= points.length - params.K_PTS; i++) {
            first = points[i];
            last = points[i + params.K_PTS - 1];

            // If the first and last point coincide
            if (first[0] == last[0] && first[1] == last[1]) {
                boolean hasDistanceSmallerThanDist = false;
                for (int j = i+1; j < (i + params.K_PTS - 1); j++) {
                    // Calculate distance between points
                    xDis = points[j][0] - first[0];
                    yDis = points[j][1] - first[1];
                    if (Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2)) <= params.DIST) {
                        hasDistanceSmallerThanDist = true;
                    }
                }
                if (!hasDistanceSmallerThanDist)
                    return true;

            } else {
                double numerator;
                double denominator;
                for (int j = i+1; j < (i + params.K_PTS - 1); j++) {
                    // Calculate distance to line defined by the first and last points
                    // reference: https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
                    numerator = Math.abs((last[0] - first[0]) * (first[1] - points[j][1])
                        - (first[0] - points[j][0]) * (last[1] - first[1]));
                    xDis = last[0] - first[0];
                    yDis = last[1] - first[1];
                    denominator = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));

                    if ((numerator / denominator) > params.DIST) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean licCond7() {
        return false;
    }
    public boolean licCond8() {
        return false;
    }
    public boolean licCond9() {
        return false;
    }
    public boolean licCond10() {
        return false;
    }
    public boolean licCond11() {
        return false;
    }
    public boolean licCond12() {
        return false;
    }
    public boolean licCond13() {
        return false;
    }
    public boolean licCond14() {
        return false;
    }
}
