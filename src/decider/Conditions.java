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
            return false;

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
        int count, x, y, curQuadrant, quadCount;
        int[] point;

        boolean[] quandrantsUsed = {false, false, false, false};

        count = 0;
        quadCount = 0;
        curQuadrant = 0;

        for(int i = 0; i < points.length; i++) {
            point = points[i];
            x = point[0];
            y = point[1];

            // 1st quadrant
            if(x >= 0 && y >= 0)
                curQuadrant = 0;

            // 2st quadrant
            else if(x < 0 && y >= 0)
                curQuadrant = 1;

            // 3st quadrant
            else if(x <= 0 && y < 0)
                curQuadrant = 2;

            // 4st quadrant
            else if(x >= 0 && y <= 0)
                curQuadrant = 3;

            /* We mark the quandrat as used, and add 1 to the total number of quandrants if this is a new quadrant */
            if(! quandrantsUsed[curQuadrant]) {
                quadCount++;
                quandrantsUsed[curQuadrant] = true;
            }

            count++;

            if(quadCount >= params.QUADS && count >= params.Q_PTS)
                return true;
            
            /* This means we need to start looking for a new consecutive pattern */
            if(quadCount < params.QUADS && count >= params.Q_PTS) {
                quandrantsUsed = new boolean[4];
                count = 0;
                quadCount = 0;
            }
        }

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
