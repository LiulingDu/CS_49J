package edu.sjsu.assignment1;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] array1 = new int[][]{{2, 4}, {3, 4}};
        int[][] array2 = new int[][]{{1, 2}, {1, 3}};
        Matrix matrix1 = new Matrix(array1);
        Matrix matrix2 = new Matrix(array2);
        Matrix resultMatrix = matrix1.multiply(matrix2);
        int[][] resultArray = resultMatrix.getMatrix();
        System.out.println(Arrays.deepToString(resultArray));
    }
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(Matrix other) {
        int m = this.matrix.length;
        int n = this.matrix[0].length;
        int p = other.matrix[0].length;
        int[][] result = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }
}

