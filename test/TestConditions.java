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

    // Test that condition 2 is false when coinciding
    @Test
    public void testCond2isFalse() {
        int[][] points = { {12, 13}, {12, 13}, {0, 1}, {-3, 3} };
        Parameters params = new Parameters(1,2,3,4,2,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);

        assertFalse("Condition 2 is not false", cond.licCond2());
    }

    // Test that condition 2 is true when angle = pi/2 and epsilon = 1
    @Test
    public void testCond2isTrue() {
        int[][] points = { {0, 1}, {0, 0}, {1, 0} };
        Parameters params = new Parameters(1,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);

        assertTrue("Condition 2 is not true", cond.licCond2());
    }

    // Test that condition 2 is true when angle = pi/2 and epsilon = 1 but they are not the first points in the list
    @Test
    public void testCond2isTrueButNotFirst() {
        int[][] points = {{0, 0}, {0, 0}, {0, 1}, {0, 0}, {1, 0} };
        Parameters params = new Parameters(1,2,3,4,1,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);

        assertTrue("Condition 2 is not true", cond.licCond2());
    }

    // Test that condition 2 is false when angle = pi/2 and epsilon = 2
    @Test
    public void testCond2isFalseEpsilon2() {
        int[][] points = { {0, 1}, {0, 0}, {1, 0} };
        Parameters params = new Parameters(1,2,3,4,2,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);

        assertFalse("Condition 2 is not true", cond.licCond2());
    }

    // Test that condition 2 returns false when number of points is < 3
    @Test
    public void testCond2YieldsFalseWhenFewPoints() {
        int[][] points = { {0, 1}, {0, 0}};
        Parameters params = new Parameters(1,2,3,4,2,10,11,15,3,2,2,2,2,2,2,2,2,2,2);
        cond = new Conditions(points, params);

        assertFalse("Condition 2 is not true", cond.licCond2());
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

    // Test that condition 3 is false when AREA1 = 9, triangle area = 8
    @Test
    public void testCond3isFalse() {
        int[][] points = { {0, 4}, {4, 0}, {0, 0} };
        Parameters params = new Parameters(300,2,3,4,1,9,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 3 is not false", cond.licCond3());
    }

    // Test that condition 3 is false when AREA1 = 9, triangle area = 8 in different order
    @Test
    public void testCond3isFalseInDifferentOrder() {
        int[][] points = {{4, 0}, {0, 0}, {0, 4} };
        Parameters params = new Parameters(300,2,3,4,1,9,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 3 is not false", cond.licCond3());
    }

    // Test that condition 3 is false when AREA1 = 9, triangle area = 8 with multiple triangles
    @Test
    public void testCond3isFalseMultipleTriangles() {
        int[][] points = {{4, 0}, {0, 0}, {0, 4}, {3,0}, {0, 0}, {0,3} };
        Parameters params = new Parameters(300,2,3,4,1,9,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 3 is not false", cond.licCond3());
    }

    // Test that condition 3 is true when AREA1 = 5, triangle area = 8
    @Test
    public void testCond3isTrue() {
        int[][] points = {{4, 0}, {0, 0}, {0, 4}, {3,0}, {0, 0}, {0,3} };
        Parameters params = new Parameters(300,2,3,4,1,5,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 3 is not true", cond.licCond3());
    }

    // Test that condition 3 is true when AREA1 = 7, triangle area = 8 and = 4.5 with multiple triangles
    @Test
    public void testCond3isTrueMultipleTriangles() {
        int[][] points = {{4, 0}, {0, 0}, {0, 4}, {3,0}, {0, 0}, {0,3} };
        Parameters params = new Parameters(300,2,3,4,1,7,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertTrue("Condition 3 is not true", cond.licCond3());
    }

    // Test that condition 3 is false when there are less than 3 points
    @Test
    public void testCond3isFalseWhenLessThan3Points() {
        int[][] points = {{4, 0}, {0, 0}};
        Parameters params = new Parameters(300,2,3,4,1,7,11,15,3,2,2,2,2,2,2,2,2,2,2);

        cond = new Conditions(points, params);

        assertFalse("Condition 3 is not false", cond.licCond3());
    }
}
