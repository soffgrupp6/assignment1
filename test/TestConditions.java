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

    // Test that condition 14 is false for numpoints < 5
    @Test
    public void testCond14isFalseForNumpointsLessThan5() {
        int[][] points = { {0, 0}, {100, -60}, {0, 1}, {76, 52} };
        Parameters params = new Parameters(0,0,0,0,0,10,0,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 14 is not false for numpoints < 5", cond.licCond14());
    }

    // Test that condition 14 is false for simple case
    @Test
    public void testCond14isFalse() {
        int[][] points = { {0, 0}, {2, 2}, {2, 2}, {3, 0}, {76, 52}, {98, 99}, {0, 4} };
        Parameters params = new Parameters(0,0,0,0,0,7,10,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 14 is not false for simple case", cond.licCond14());
    }

    // Test that condition 14 is true for simple case
    @Test
    public void testCond14isTrue() {
        int[][] points = { {0, 0}, {2, 2}, {2, 2}, {3, 0}, {76, 52}, {98, 99}, {0, 4} };
        Parameters params = new Parameters(0,0,0,0,0,5,10,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 14 is not true for simple case", cond.licCond14());
    }

    // Test that condition 14 is false for exact area1
    @Test
    public void testCond14isFalseForExactArea1() {
        int[][] points = { {0, 0}, {2, 2}, {2, 2}, {3, 0}, {76, 52}, {98, 99}, {0, 4} };
        Parameters params = new Parameters(0,0,0,0,0,6,10,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 14 is not false for triangle with exactly area1", cond.licCond14());
    }

    // Test that condition 14 is false for exact area2
    @Test
    public void testCond14isFalseForExactArea2() {
        int[][] points = { {0, 0}, {2, 2}, {2, 2}, {3, 0}, {76, 52}, {98, 99}, {0, 4} };
        Parameters params = new Parameters(0,0,0,0,0,2,6,0,0,0,0,0,0,0,0,0,2,2,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 14 is not false for triangle with exactly area2", cond.licCond14());
    }

    // Test that condition 14 is true for multiple triangles
    @Test
    public void testCond14isTrueForMultipleTriangles() {
        int[][] points = { {0, 0}, {2, 2}, {2, 2}, {3, 0}, {76, 52}, {98, 99}, {99, 4}, {1, 3} };
        Parameters params = new Parameters(0,0,0,0,0,10,5,0,0,0,0,0,0,0,0,0,1,3,0);

        cond = new Conditions(points, params);

        assertTrue("Condition 14 is not true for multiple triangles", cond.licCond14());
    }

    // Test that condition 14 is false for multiple triangles
    @Test
    public void testCond14isFalseForMultipleTriangles() {
        int[][] points = { {1, 1}, {2, 2}, {4, 2}, {3, 5}, {76, 52}, {98, 99}, {-20, 20}, {1, 3} };
        Parameters params = new Parameters(0,0,0,0,0,10,2,0,0,0,0,0,0,0,0,0,1,3,0);

        cond = new Conditions(points, params);

        assertFalse("Condition 14 is not false for multiple triangles", cond.licCond14());
    }

}
