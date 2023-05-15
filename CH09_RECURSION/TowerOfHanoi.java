//You have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle
//        starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
//        top of an even larger one).
//        You have the following constraints:
//        (1) Only one disk can be moved at a time.
//        (2) A disk is slid off the top of one tower onto another tower.
//        (3) A disk cannot be placed on top of a smaller disk. Write a program to move the disks from
//        the first tower to the
//        last using Stacks.



package CH09_RECURSION;

public class TowerOfHanoi { //O(2^n)
//
//    The time complexity of the
//    Tower of Hanoi algorithm is O(2^n), where "n" is
//    the number of disks. This means that the number of steps
//
//    required to solve the problem increases exponentially with the number of disks.
//
//    The algorithm requires a minimum of 2^n - 1 steps
//    to solve the problem for "n" disks. As the number
//    of disks increases, the time required to solve the problem also increases drastically.
//
//    The reason for this time complexity is that at each
//        step, the algorithm needs to make a recursive call
//    to move "n-1" disks from one peg to another. Since this operation
//    is performed recursively for each disk, the number of operations
//    required grows exponentially with the number of disks.
//
//            Therefore, it is important to keep the number of disks as small
//    as possible to minimize the time required to solve the problem.


    // method to solve Tower of Hanoi problem
    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {

        // base case: if there is only one disk to move, simply move it from the source to destination rod
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }

        // move n-1 disks from the source rod to auxiliary rod
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);

        // move the nth disk from the source rod to destination rod
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);

        // move n-1 disks from the auxiliary rod to destination rod
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
    }

    // main method to run the program
    public static void main(String[] args) {

        int n = 3; // number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // call the towerOfHanoi method with source rod as A, destination rod as C, and auxiliary rod as B

    }
}

