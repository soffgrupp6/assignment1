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

    // Test that condition 7 is true for simple case
    @Test
    public void testCond7isTrueSimpleCase() {
        int[][] points = { {0, 0}, {0, 0}, {5, 5} };
        Parameters params = new Parameters(7,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 7 is not true for simple case", cond.licCond7());
    }

    // Test that condition 7 is false for simple case
    @Test
    public void testCond7isFalseSimpleCase() {
        int[][] points = { {0, 0}, {0, 0}, {5, 5} };
        Parameters params = new Parameters(8,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 7 is not false for simple case", cond.licCond7());
    }

    // Test that condition 7 is true for complex case
    @Test
    public void testCond7isTrueComplexCase() {
        int[][] points = { {0, 0}, {-1, 4}, {5, 5}, {6, 6}, {7, 7}, {-9, 13} };
        Parameters params = new Parameters(12,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 7 is not true for complex case", cond.licCond7());
    }

    // Test that condition 7 is false for NUMPOINTS < 3
    @Test
    public void testCond7isFalseTwoPoints() {
        int[][] points = { {0, 0}, {-1, 4} };
        Parameters params = new Parameters(12,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 7 is not false for two points", cond.licCond7());
    }

    // Test that condition 5 is false
    @Test
    public void testCond5isFalse() {
        int[][] points = { {12, 13}, {13, 213}, {14, 1}, {15, 3} };
        Parameters params = new Parameters(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 5 is not false", cond.licCond5());
    }

    // Test that condition 5 is true
    @Test
    public void testCond5isTrue() {
        int[][] points = { {12, 13}, {13, 213}, {14, 1}, {10, 3} };
        Parameters params = new Parameters(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 5 is not true", cond.licCond5());
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

    // Test that condition 12 is true
    @Test
    public void testCond12isTrue() {
        int[][] points = { {0, 0}, {2, 2}, {4, 3}, {1, 1} };
        Parameters params = new Parameters(4,3,0,0,0,4,0,0,0,0,0,1,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 12 is not true", cond.licCond12());
    }

    // Test that condition 12 is false
    @Test
    public void testCond12isFalse() {
        int[][] points = { {0, 0}, {19, -2}, {4, 3}, {1, 1} };
        Parameters params = new Parameters(4,3,0,0,0,4,0,0,0,0,0,1,0,0,0,0,0,0,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 12 is not false", cond.licCond12());
    }
}
