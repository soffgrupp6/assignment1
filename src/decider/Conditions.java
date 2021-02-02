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
        for(int i=1; i<this.points.length; i++) {
            if(this.points[i][0] - this.points[i-1][0] < 0)
                return true;
        }
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
        if (points.length < 3)
           return false;

        float xDis, yDis;
        int j;

        // For each pair i and j
        for (int i = 0; i < points.length - params.K_PTS - 1; i++) {

            // K_PTS intervening points
            j = i + params.K_PTS + 1;

            xDis = points[i][0] - points[j][0];
            yDis = points[i][1] - points[j][1];

            // Distance between point i and j greater than LENGTH1
            if(Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2)) > params.LENGTH1)
                return true;
        }
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
            distA = Math.sqrt(Math.abs(Math.pow(points[i][0] - cx, 2) - Math.pow(points[i][1] - cy, 2)));
            distB = Math.sqrt(Math.abs(Math.pow(points[j][0] - cx, 2) - Math.pow(points[j][1] - cy, 2)));
            distC = Math.sqrt(Math.abs(Math.pow(points[k][0] - cx, 2) - Math.pow(points[k][1] - cy, 2)));

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
        if(points.length < 5)
            return false;

        int[] a,b,c;
        float area;

        // a, b, c are different points which form a triangle with area area 
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
        if(points.length < 3)
            return false;
        
        int[] a,b;

        // a and b are two points separated by G_PTS
        for(int i = 0; i < points.length - params.G_PTS - 1; i++){
            a = points[i];
            b = points[params.G_PTS + 1 + i];
            if(b[0] - a[0] < 0)
                return true;
        }

        return false;
    }
    public boolean licCond12() {
        return false;
    }
    public boolean licCond13() {
        return false;
    }

    public boolean licCond14() {
        if (points.length < 5)
            return false;

        int[] a,b,c;
        double area;

        boolean triangleAreaLargerThanAREA1 = false;
        boolean triangleAreaSmallerThanAREA2 = false;

        // For each triplet of points a, b, c
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            a = points[i];
            b = points[params.E_PTS + 1 + i];
            c = points[params.E_PTS + params.F_PTS + 2 + i];

            // Calculate area of the triangle
            area = Math.abs((a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0);

            if (area > params.AREA1)
                triangleAreaLargerThanAREA1 = true;
            if (area < params.AREA2)
                triangleAreaSmallerThanAREA2 = true;
        }

        if (triangleAreaLargerThanAREA1 && triangleAreaSmallerThanAREA2)
            return true;

        return false;
    }
}
