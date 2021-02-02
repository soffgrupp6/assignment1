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

    // Test that condition 0 yields false when number of points < 2
    @Test
    public void testCond0YieldsExceptionOnFewPoints() {
        int[][] points = { {12, 13} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);
        assertFalse("Condition 0 is not false", cond.licCond0());
    }

    // Test that condition 4 is true with three consecutive points in 2 different quadrants
    @Test
    public void testCond4isTrue3Points2Quads() {
        int[][] points = { {-1, 0}, {0, 1}, {0, 2} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,2,3,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 4 is not true", cond.licCond4());
    }

    // Test that condition 4 is true with three consecutive points in 2 different quadrants, with points not in the beginning
    @Test
    public void testCond4isTrue3Points2QuadsNotBeginning() {
        int[][] points = {{0, 0}, {0, 0}, {0,0}, {-1, 0}, {0, 1}, {0, 2} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,2,3,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 4 is not true", cond.licCond4());
    }

    // Test that condition 4 is false with three consecutive points in 3 different quadrants
    @Test
    public void testCond4isFalse3Points3Quads() {
        int[][] points = { {-1, 0}, {0, 1}, {0, 2}, {0, 3} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,3,3,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 4 is not false", cond.licCond4());
    }

    // Test that condition 4 is true with three consecutive points in 3 different quadrants in the middle of many points
    @Test
    public void testCond4isTrue3Points3QuadsMiddle() {
        int[][] points = { {0, 0}, {0, 1}, {0, 1}, {-1, 0}, {-1, -1}, {0,3}, {0,4}, {2,3} };
        Parameters params = new Parameters(20,2,3,4,1,10,11,15,3,3,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 4 is not true", cond.licCond4());
    }
}
