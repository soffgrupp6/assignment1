public class Decider {

    public class Parameters {
        public double LENGTH1;
        public double LENGTH2;
        public double RADIUS1;
        public double RADIUS2;
        public double EPSILON;
        public double AREA1;
        public double AREA2;
        public double DIST;
        public int QUADS;
        public int Q_PTS;
        public int N_PTS;
        public int K_PTS;
        public int A_PTS;
        public int B_PTS;
        public int C_PTS;
        public int D_PTS;
        public int E_PTS;
        public int F_PTS;
        public int G_PTS;
    }

    // input variables, should be arguments in constructor
    int numpoints; // 2 < numpoints < 100
    int[][] points;
    int[][] LCM; // 0 = ANDD, 1 = ORR, 2 = NOTUSED
    boolean[] PUV;
    Parameters parameters;

    // variables we create
    boolean[][] PUM;
    boolean[] FUV;
    boolean[] CMV;

    Decider() {
        this.numpoints = numpoints;
        this.points = points;
        this.LCM = LCM;
        this.PUV = PUV;
        this.parameters = parameters;
        this.PUM = new boolean[15][15];
        this.FUV = new boolean[15];
        this.CMV = new boolean[15];
    }

    // licCond functions modify this.CMV to avoid passing parameters
    private void licCond0() {
    }
    private void licCond1() {
    }
    private void licCond2() {
    }
    private void licCond3() {
    }
    private void licCond4() {
    }
    private void licCond5() {
    }
    private void licCond6() {
    }
    private void licCond7() {
    }
    private void licCond8() {
    }
    private void licCond9() {
    }
    private void licCond10() {
    }
    private void licCond11() {
    }
    private void licCond12() {
    }
    private void licCond13() {
    }
    private void licCond14() {
    }
    private void computePUM() {
    }
    private void computeFUV() {
    }

    // calls all functions and returns the answer
    public boolean Decide() {
        return false;
    }

}
