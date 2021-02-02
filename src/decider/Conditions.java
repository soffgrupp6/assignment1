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
        int[][] c = {{0,0}, {0,0}, {0,0}}; // Three consecutive points
        double disC0C1, disC1C2, disC0C2, cosC1, angle;

        if(points.length < 3)
            return false;

        for(int i = 0; i <= points.length - 3; i++) {
             /* Add points */
            c[0] = points[i];
            c[1] = points[i + 1];
            c[2] = points[i + 2];

            /* Make sure points does not coincide */
            if(c[0][0] == c[1][0] && c[0][1] == c[1][1])
                continue;
            if(c[2][0] == c[1][0] && c[2][1] == c[1][1])
                continue;

            /* Calculate the distances between the three points */
            disC0C1 = Math.sqrt(Math.pow(c[0][0] - c[1][0], 2) + Math.pow(c[0][1] - c[1][1], 2));
            disC1C2 = Math.sqrt(Math.pow(c[1][0] - c[2][0], 2) + Math.pow(c[1][1] - c[2][1], 2));
            disC0C2 = Math.sqrt(Math.pow(c[0][0] - c[2][0], 2) + Math.pow(c[0][1] - c[2][1], 2));

            /* Here we use the cosine formula to calculate the cosine of the vertex of c1 */
            cosC1 = (Math.pow(disC0C2, 2) - Math.pow(disC1C2, 2) - Math.pow(disC0C1, 2)) / (-1 * disC1C2 * disC0C1);

            /* Now we take the arccos to get the angle */
            angle = Math.acos(cosC1);

            if(angle < (Math.PI - params.EPSILON) || angle > (Math.PI + params.EPSILON))
                return true;
        }
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

        if(points.length < 5)
           return false;

        double distA, distB, distC;
        int j, k;
        int cx, cy;

        // For each three points i, j and k
        for(int i = 0; i < points.length - (params.A_PTS + params.B_PTS) - 2; i++) {

            // A_PTS intervening points
            j = i + params.A_PTS + 1;
            k = j + params.B_PTS + 1;

            // Radius of points
            // Calculate the centeroid of the triangle formed by the three points
            cx = (points[i][0] + points[j][0] + points[k][0]) / 3;
            cy = (points[i][1] + points[j][1] + points[k][1]) / 3;

            // Find largest distance from the centeroid to use as radius
            distA = Math.sqrt(Math.pow(points[i][0] - cx, 2) - Math.pow(points[i][1] - cy, 2));
            distB = Math.sqrt(Math.pow(points[j][0] - cx, 2) - Math.pow(points[j][1] - cy, 2));
            distC = Math.sqrt(Math.pow(points[k][0] - cx, 2) - Math.pow(points[k][1] - cy, 2));

            double distD = Math.max(distA, distB);
            double radius = Math.max(distC, distD);

            // Compare radius to given radius
            if (radius >= params.RADIUS1)
                return true;
        }
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
