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
