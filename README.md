# Assignment 1

This is assignment 1 in DD2480. It implements the function Decide(), which determines whether a set of proposed conditions are met.

The specification is given [here](https://canvas.kth.se/courses/22002/files/3520644/download).

## Purpose

The purpose of this program is to, given a set of points and parameters together with input vectors, determine whether to launch the interceptor program (return true or false). If the conditions are met, the program returns TRUE. If the conditions are not met, the program returns FALSE.

## Contributions

The parts of this program were split evenly and implemented mostly individually by all 4 members of the group. The basic code skeleton was decided upon and developed together. The different LIC conditions were worked on by each person who implemented at least 3 of the 15 conditions, including tests. The code was then refactored by the group together.

## Testing

Junit jar files (junit-4.13.1.jar, hamcrest-core-1.3.jar) are needed in the root of the repository to run automated tests. They are available [here](https://github.com/junit-team/junit4/wiki/Download-and-Install).

To run the tests (bash):

    ./test.sh
