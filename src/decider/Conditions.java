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
        int[][] c = { {0, 0}, {0, 0}, {0, 0} };
        double disC0C1, disC1C2, disC0C2, area, s;

        if(points.length < 3)
            return false;
            
        for(int i = 0; i <= points.length - 3; i++) {
             /* Add points */
            c[0] = points[i];
            c[1] = points[i + 1];
            c[2] = points[i + 2];

            /* Calculate the distances between the three points */
            disC0C1 = Math.sqrt(Math.pow(c[0][0] - c[1][0], 2) + Math.pow(c[0][1] - c[1][1], 2));
            disC1C2 = Math.sqrt(Math.pow(c[1][0] - c[2][0], 2) + Math.pow(c[1][1] - c[2][1], 2));
            disC0C2 = Math.sqrt(Math.pow(c[0][0] - c[2][0], 2) + Math.pow(c[0][1] - c[2][1], 2));

            /* Here we use Herons formula to calculate the area */
            s = (disC0C1 + disC1C2 + disC0C2) / 2;
            area = Math.sqrt(s * (s - disC0C1) * (s - disC1C2) * (s - disC0C2));

            if(area > params.AREA1)
                return true;
        }

        return false;
    }
    public boolean licCond4() {
        return false;
    }
    public boolean licCond5() {
        return false;
    }
    public boolean licCond6() {
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
