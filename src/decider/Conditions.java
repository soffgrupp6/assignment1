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
        return false;
    }
    public boolean licCond1() {
        return false;
    }
    public boolean licCond2() {
        int[][] c = {{0,0}, {0,0}, {0,0}}; // Three consecutive points
        double disC0C1, disC1C2, disC0C2, cosC1, angle;

        if(points.length < 3)
            throw new IllegalArgumentException("Invalid number of points");

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
