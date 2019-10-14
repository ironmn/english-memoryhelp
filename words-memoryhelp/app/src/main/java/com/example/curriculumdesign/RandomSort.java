package com.example.curriculumdesign;


import java.util.Random;

public class RandomSort {
    private Random random = new Random();
    private static final int SIZE = 10;
    private int[] positions = new int[SIZE];

    public RandomSort() {
        for(int index=0; index<SIZE; index++) {
            positions[index] = index;
        }
        printPositions();
    }
    public void changePosition() {
        for(int index=SIZE-1; index>=0; index--) {
            exchange(random.nextInt(index+1), index);
        }
        printPositions();
    }
    private void exchange(int p1, int p2) {
        int temp = positions[p1];
        positions[p1] = positions[p2];
        positions[p2] = temp;
    }
    private void printPositions() {
        for(int index=0; index<SIZE; index++) {
            System.out.print(positions[index]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RandomSort rs = new RandomSort();
        rs.changePosition();
        rs.changePosition();
        rs.changePosition();
    }
}
