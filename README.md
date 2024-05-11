## **Introduction**

This project aims to make me comfortable with a basic computer system and its functionalities using JAVA. 

___

## **Description**

CPU emulator software that supports a basic instruction set given below. I assumed that the computer has 256 bytes of available memory (M) initially set to zero. Emulator loads a program code from a text file. 

The following example code is an app that can compute the sum of the numbers between 0 and 20. 
___

**A Hello world app that computes the sum of the numbers between 0 to 20**

0 START

1 LOAD 20

2 STORE 200

3 LOAD 0

4 STORE 201

5 STORE 202

6 CMPM 200

7 CJMP 15

8 LOADM 202

9 ADDM 201

10 STORE 202

11 LOADM 201

12 ADD 1

13 STORE 201

14 JMP 6

15 LOADM 202

16 DISP

17 HALT
___

The output will be:

Accumulator after LOADM: 210 \
Accumulator after all program executed: 210 \
Program halted.
