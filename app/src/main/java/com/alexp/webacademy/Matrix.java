package com.alexp.webacademy;

import java.util.Arrays;

/**
 * Матрица NxN
 * Подсчет суммы элементов верхней диагональной матрицы
 */
public class Matrix {
    private int nSize;
    private int[][] matrica;

    public int getnSize() {
        return nSize;
    }

    public int[][] getMatrica() {
        return matrica;
    }

    public void setMatrica(int[][] matrica) {
        this.matrica = matrica;
    }

    public int getMatricaItem(int row, int column) {
        return matrica[row][column];
    }

    public void setMatrica(int value, int row, int column) {
        this.matrica[row][column] = value;
    }

    @Override
    public String toString() {
        return "Matrix = \r\n" + Arrays.deepToString(matrica).replaceAll("],", "],\r\n");
    }

    public Matrix(int volume) {
        this.nSize = volume;
        matrica = new int[nSize][nSize];
    }

    public Matrix(int volume, int minValue, int maxValue) {
        this.nSize = volume;
        matrica = new int[nSize][nSize];
        randomizeMatrix(minValue, maxValue);
    }


    public void randomizeMatrix(int minValue, int maxValue) {
        for (int i = 0; i < this.nSize; i++) {
            for (int j = 0; j < this.nSize; j++) {
                this.matrica[i][j] = minValue + (int) (Math.random() * ((maxValue - minValue) + 1));
            }
        }
    }

    public int sumOfMatrix() {
        int sumM = 0;
        for (int i = 0; i < this.nSize; i++) {
            for (int j = i; j < this.nSize; j++) {
                sumM = sumM + this.matrica[i][j];
            }
        }
        return sumM;
    }

}
