package com.example;

import java.util.Arrays;

/**
 * Матрица NxN
 * Подсчет суммы элементов верхней диагональной матрицы
 */
public class Matrix {

    private int matrixSize;
    private int[][] matrixX;


    public Matrix(int volume) {
        setMatrixSize(volume);
        matrixX = new int[matrixSize][matrixSize];
    }

    public Matrix(int volume, int minValue, int maxValue) {
        setMatrixSize(volume);
        matrixX = new int[matrixSize][matrixSize];
        randomizeMatrix(minValue, maxValue);
    }

    //Fill Matrix with random values
    public void randomizeMatrix(int minValue, int maxValue) {
        for (int i = 0; i < getMatrixSize(); i++) {
            for (int j = 0; j < getMatrixSize(); j++) {
                setMatrixItem(minValue + (int) (Math.random() * ((maxValue - minValue) + 1)), i, j);
            }
        }
    }

    public int sumOfMatrix() {
        int sumM = 0;
        for (int i = 0; i < getMatrixSize(); i++) {
            for (int j = i; j < getMatrixSize(); j++) {
                sumM = sumM + getMatrixItem(i, j);
            }
        }
        return sumM;
    }

    public void setMatrixSize(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    public int getMatrixSize() {
        return matrixSize;
    }

    public int[][] getMatrixX() {
        return matrixX;
    }

    public void setMatrixX(int[][] matrixX) {
        this.matrixX = matrixX;
    }

    public int getMatrixItem(int row, int column) {
        return matrixX[row][column];
    }

    public void setMatrixItem(int value, int row, int column) {
        this.matrixX[row][column] = value;
    }

    @Override
    public String toString() {
        return "Matrix = \r\n" + Arrays.deepToString(matrixX).replaceAll("],", "],\r\n");
    }
}
