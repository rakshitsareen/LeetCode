package com.crackingthecodinginterview;

public class RotateMatrix {

	public void rotateMatrix(int[][] a) {
		int N = a.length;
		int temp;
		int temp2;
		for (int i = 0; i < N / 2; i++)
			for (int j = 0; j < N / 2; j++) {

				temp = a[j][N - i - 1];
				a[j][N - i - 1] = a[i][j];

				temp2 = a[N - i - 1][N - j - 1];
				a[N - i - 1][N - j - 1] = temp;

				temp = a[N - j - 1][i];
				a[N - j - 1][i] = temp2;

				a[i][j] = temp;
			}
		if (N % 2 == 1) {
			for (int i = 0; i < N / 2; i++) {
				temp = a[N / 2][N - i - 1];
				a[N / 2][N - i - 1] = a[i][N / 2];

				temp2 = a[N - i - 1][N - N / 2 - 1];
				a[N - i - 1][N - N / 2 - 1] = temp;

				temp = a[N - N / 2 - 1][i];
				a[N - N / 2 - 1][i] = temp2;

				a[i][N / 2] = temp;
			}
		}
	}

	public void rotateMatrix2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < (n + 1) / 2; j++) {
				int temp = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] b = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		RotateMatrix pro = new RotateMatrix();
		pro.rotateMatrix(a);
		// pro.rotateMatrix(b);
		for (int[] row : a) {
			for (int cha : row) {
				System.out.print(cha + " ");
			}
			System.out.print("\n");
		}
		for (int[] row : b) {
			for (int cha : row) {
				System.out.print(cha + " ");
			}
			System.out.print("\n");
		}
	}

}
