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

    // Test that condition 6 is true for a simple case
    @Test
    public void testCond6simpleTrue() {
        int[][] points = { {0, 0}, {30, 30}, {0, 15}, {-3, 3} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,10,3,2,3,3,3,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 6 is not true for simple case", cond.licCond6());
    }

    // Test that condition 6 is false for a simple case
    @Test
    public void testCond6simpleFalse() {
        int[][] points = { {0, 0}, {1, 10}, {0, 15}, {-3, 3} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,10,3,2,3,3,3,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 6 is not false for simple case", cond.licCond6());
    }

    // Test that condition 6 is false when distance is exactly DIST
    @Test
    public void testCond6FalseForExactlyDistanceDIST() {
        int[][] points = { {0, 0}, {10, 10}, {0, 15} };
        Parameters params = new Parameters(20,2,3,4,10,10,10,10,3,2,3,3,3,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 6 is not false for distance = DIST", cond.licCond6());
    }

    // Test that condition 6 is false for coinciding points
    @Test
    public void testCond6FalseForCoincidingPoints() {
        int[][] points = { {10, 10}, {0, 0}, {9, 8}, {-3, -2}, {0, 0} };
        Parameters params = new Parameters(20,2,3,4,4,4,4,4,3,2,4,4,4,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 6 is not false for coinciding points", cond.licCond6());
    }

    // Test that condition 6 is true for coinciding points
    @Test
    public void testCond6TrueForCoincidingPoints() {
        int[][] points = { {10, 10}, {0, 0}, {9, 8}, {-3, -4}, {0, 0} };
        Parameters params = new Parameters(20,2,3,4,4,4,4,4,3,2,4,4,4,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 6 is not true for coinciding points", cond.licCond6());
    }

    // Test that condition 6 is true for complex case
    @Test
    public void testCond6TrueForComplexCase() {
        int[][] points = { {10, 10}, {0, 0}, {9, 8}, {-3, -4}, {0, 0}, {1, 1}, {7, 9}, {-15, -9} };
        Parameters params = new Parameters(20,2,3,4,10,10,10,10,3,2,4,5,4,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 6 is not true for many points", cond.licCond6());
    }

    // Test that condition 6 is false for complex case
    @Test
    public void testCond6FalseForComplexCase() {
        int[][] points = { {10, 10}, {0, 0}, {9, 8}, {-3, -4}, {0, 0}, {1, 1}, {2, 3}, {-15, -9} };
        Parameters params = new Parameters(20,2,3,4,50,50,50,50,3,2,4,5,4,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 6 is not false for many points", cond.licCond6());
    }
}
