# /bin/bash

javac -cp .:junit-4.13.1.jar:hamcrest-core-1.3.jar:src test/*.java

java -cp .:junit-4.13.1.jar:hamcrest-core-1.3.jar:src:test org.junit.runner.JUnitCore TestConditions TestDecider
