package com.game.test;

import javax.swing.*;
import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        int[] _1 = {1,2,3,4,5};
        int[] _2 = {6,7,8,9,10};
        int[] _3 = {11,12,13,14,15};
        int[] _4 = {16,17,18,19,20};
        int[][] __ = {_1, _2, _3, _4,};

        Random random = new Random();

        for (int i = 0; i < __.length; i++) {
            for (int j = 0; j < __[i].length; j++) {
                int row = random.nextInt(__.length);
                int column = random.nextInt(__[i].length);
                int temp = __[i][j];
                __[i][j] = __[row][column];
                __[row][column] = temp;
            }
        }

        for (int i = 0; i < __.length; i++) {
            for (int j = 0; j < __[i].length; j++) {
                System.out.print(__[i][j]+" ");
            }
            System.out.println();
        }
    }
}
