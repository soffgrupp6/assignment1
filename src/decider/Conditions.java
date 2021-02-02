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
        if(points.length < 5)
            return false;

        int[] a,b,c;
        float area;

        for(int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            a = points[i];
            b = points[params.E_PTS + 1 + i];
            c = points[params.E_PTS + params.F_PTS + 2 + i];
            area = Math.abs((a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2);
            if(area > params.AREA1)
                return true;
        }

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
