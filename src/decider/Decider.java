package decider;

public class Decider {

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

    private void computeConds() {
        Conditions cond = new Conditions(points, parameters);
        CMV[0] = cond.licCond0();
        CMV[1] = cond.licCond1();
        CMV[2] = cond.licCond2();
        CMV[3] = cond.licCond3();
        CMV[4] = cond.licCond4();
        CMV[5] = cond.licCond5();
        CMV[6] = cond.licCond6();
        CMV[7] = cond.licCond7();
        CMV[8] = cond.licCond8();
        CMV[9] = cond.licCond9();
        CMV[10] = cond.licCond10();
        CMV[11] = cond.licCond11();
        CMV[12] = cond.licCond12();
        CMV[13] = cond.licCond13();
        CMV[14] = cond.licCond14();
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
