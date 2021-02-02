package decider;
/**
 * Decider class computes on the input point data
 * using parameters to calculate if the missiles should
 * be launched or not.
 */
public class Decider {

    // input variables, should be arguments in constructor
    int[][] points;
    int[][] LCM; // 0 = ANDD, 1 = ORR, 2 = NOTUSED
    boolean[] PUV;
    Parameters parameters;

    // variables we create
    boolean[][] PUM;
    boolean[] FUV;
    boolean[] CMV;

    public Decider(/*int[][] points, int[][] LCM, boolean[] PUV, Parameters parameters*/) {
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

    /**
     * Compute the PUM
     */
    private void computePUM() {
        int operator;

        operator = 0;

        /* Iterate the permutations of CMV and apply the operator to form PUM */
        for(int i = 0; i < CMV.length; i++) {
            for(int j = 0; j < CMV.length; j++) {
                operator = LCM[i][j];

                // Determine which operation to use
                switch(operator) {

                // ANDD
                case 0:
                    PUM[i][j] = CMV[i] && CMV[j];
                    break;

                // ORR
                case 1:
                    PUM[i][j] = CMV[i] || CMV[j];
                    break;

                // NOTUSED
                case 2:
                    PUM[i][j] = true;
                    break;

                }
            }
        }

    }

    private void computeFUV() {
        outer:
        for (int i = 0; i < FUV.length; i++) {
            // If PUV is entry is false set to true
            if (!PUV[i]) {
                FUV[i] = true;
            } else {
                // Go trough the ith row in the PUM
                for (int j = 0; j < PUM.length; j++) {
                    if (!PUM[i][j]) {
                        FUV[i] = false;
                        continue outer;
                    }
                }
                FUV[i] = true;
            }
        }
    }

    // calls all functions and returns the answer
    public boolean Decide() {
        return false;
    }

}
