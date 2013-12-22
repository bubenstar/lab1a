package com.onpu.quality2013.lab1a;

import java.util.Arrays;
import java.util.Collections;

public class MatrixManager {

	public int[][] changeBoundColumns(int[][] matrix)
			throws IllegalArgumentException {
		if (matrix == null || matrix.length == 0) {
			throw new IllegalArgumentException("Matrix is null or empty");
		}
		int cols = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			int temp = matrix[i][0];
			matrix[i][0] = matrix[i][cols - 1];
			matrix[i][cols - 1] = temp;
		}
		return matrix;
	}

	public int[][] descSortEverySecondColumn(int[][] matrix)
			throws IllegalArgumentException {
		if (matrix == null || matrix.length == 0) {
			throw new IllegalArgumentException("Matrix is null or empty");
		}
		if (matrix[0].length > 1 && matrix.length > 1) {

			for (int i = 1; i < matrix[0].length; i = i + 2) {

				int[] sortedColumn = sortColumn(getColumn(i, matrix));
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = sortedColumn[j];
				}
			}
			return matrix;
		} else
			throw new IllegalArgumentException();
	}

	private int[] sortColumn(Integer[] column) {
		int[] result = new int[column.length];
		Arrays.sort(column, Collections.reverseOrder());
		for (int i = 0; i < column.length; i++) {
			result[i] = column[i].intValue();
		}
		return result;
	}

	private Integer[] getColumn(int index, int[][] matrix) {
		Integer[] result = new Integer[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			result[i] = matrix[i][index];
		}
		return result;
	}
	
	//-------------------------------------------------------------------------------------
	//YARIK LABA 1
	
	public int getAverage(int[][] matrix) throws IllegalArgumentException{
		if (matrix == null || matrix.length == 0) {
			throw new IllegalArgumentException("Matrix is null or empty");
		}
		if (matrix.length != matrix[0].length){
			throw new IllegalArgumentException("Matrix is not square");
		}
		int length = matrix.length - 1;
		int max = matrix[0][0];
		int min = matrix[0][0];
		for (int i = 0; i < length; i++ ){
			for (int j = 0; j < length - i; j++){
				if (matrix[i][j] > max){
					max = matrix[i][j];
				} else if (matrix[i][j] < min) {
					min = matrix[i][j];
				}
			}
		}
		return (min + max)/2;
	}

}
