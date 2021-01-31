public class Decider {

    // input variables, should be arguments in constructor
    int numpoints; // 2 < numpoints < 100
    int[][] distances;
    int[][] LCM; // 0 = ANDD, 1 = ORR, 2 = NOTUSED
    boolean[] PUV;
    //PARAMETERS[20] parameters;

    // variables we create
    boolean[][] PUM;
    boolean[] FUV;
    boolean[] CMV;

    Decider() {
        this.numpoints = numpoints;
        this.distances = distances;
        this.LCM = LCM;
        this.PUV = PUV;
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