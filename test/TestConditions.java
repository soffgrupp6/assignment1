import decider.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestConditions {

    Conditions cond;

    @Before
    public void setUp() {
        int[][] points = { {12, 13}, {31, 213}, {0, 1}, {-3, 3} };
        Parameters params = new Parameters(1,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);
    }

    // Test that condition 0 is false
    @Test
    public void testCond0isFalse() {
        int[][] points = { {12, 13}, {31, 213}, {0, 1}, {-3, 3} };
        Parameters params = new Parameters(300,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 0 is not false", cond.licCond0());
    }

    // Test that condition 0 is true
    @Test
    public void testCond0isTrue() {
        int[][] points = { {12, 13}, {31, 213}, {0, 1}, {-3, 3} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 0 is not true", cond.licCond0());
    }

    // Test that condition 0 yields exception when number of points < 2
    @Test(expected = IllegalArgumentException.class)
    public void testCond0YieldsExceptionOnFewPoints() {
        int[][] points = { {12, 13} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);
        cond.licCond0();
    }

    // Test that condition 10 is false
    @Test
    public void testCond10isFalse() {
        int[][] points = { {0, 0}, {100, -60}, {0, 1}, {0, 5}, {76, 52}, {98, 99}, {2, 0} };
        Parameters params = new Parameters(0,0,0,0,0,10,0,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);
        
        assertFalse("Condition 10 is not false", cond.licCond10());
    }

    // Test that condition 10 is true
    @Test
    public void testCond10isTrue() {
        int[][] points = { {0, 0}, {100, -60}, {0, 1}, {0, 5}, {76, 52}, {98, 99}, {2, 0} };
        Parameters params = new Parameters(0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);
        
        assertTrue("Condition 10 is not true", cond.licCond10());
    }

}
