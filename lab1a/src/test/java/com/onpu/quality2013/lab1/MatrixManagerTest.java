package com.onpu.quality2013.lab1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.onpu.quality2013.lab1a.MatrixManager;

public class MatrixManagerTest {

	private MatrixManager matrixManager;

	@Before
	public void before() {
		matrixManager = new MatrixManager();
	}

	@Test
	public void testChangeBoundColumns() {
		int[][] matrix = { { 1, 4, 5 }, { 6, 10, 3 }, { 5, 4, 90 },
				{ 78, 43, 1 } };
		int[][] expectedMatrix = { { 5, 4, 1 }, { 3, 10, 6 }, { 90, 4, 5 },
				{ 1, 43, 78 } };
		int[][] actualMatrix = matrixManager.changeBoundColumns(matrix);
		assertMatrix(expectedMatrix, actualMatrix);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testChangeBoundColumnsNullMatrix() {
		matrixManager.changeBoundColumns(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testChangeBoundColumnsEmptyMatrix() {
		int[][] matrix = {};
		matrixManager.changeBoundColumns(matrix);
	}

	@Test
	public void testChangeBoundColumnsMatrixIsOneColumn() {
		int[][] matrix = { { 3 }, { 4 }, { 5 } };
		int[][] expectedMatrix = matrix;

		int[][] actualMatrix = matrixManager.changeBoundColumns(matrix);

		assertMatrix(expectedMatrix, actualMatrix);
	}

	@Test
	public void testDescSortEverySecondColumn() {
		int[][] matrix = { { 1, 4, 5, 1 }, { 6, 10, 3, 2 }, { 5, 4, 90, 3 },
				{ 78, 43, 1, 4 } };
		int[][] expectedMatrix = { { 1, 43, 5, 4 }, { 6, 10, 3, 3 },
				{ 5, 4, 90, 2 }, { 78, 4, 1, 1 } };

		int[][] actualMatrix = matrixManager.descSortEverySecondColumn(matrix);

		assertMatrix(expectedMatrix, actualMatrix);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescSortEverySecondColumnNullMatrix() {
		matrixManager.descSortEverySecondColumn(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescSortEverySecondColumnEmptyMatrix() {
		int[][] matrix = {};
		matrixManager.changeBoundColumns(matrix);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescSortEverySecondColumnWhenMatrixIsOneColumn() {
		int[][] matrix = { { 3 }, { 4 }, { 5 } };
		matrixManager.descSortEverySecondColumn(matrix);
	}
	
	private void assertMatrix(int[][] expectedMatrix, int[][] actualMatrix) {
		for (int i = 0; i < actualMatrix.length; i++) {
			for (int j = 0; j < actualMatrix[i].length; j++) {
				assertEquals(actualMatrix[i][j], expectedMatrix[i][j]);
			}
		}
	}
	
	//------------------------------------------------------------------------------------
	//YARIK LAB1 TEST
	
	@Test
	public void testGetAverage() {
		int[][] matrix = {{ 2, 4, 5, 1 },
						  { 6, 10, 3, 2 },
						  { 5, 4, 3, 3 },
						  { 4, 2, 1, 4 }};
		int expected = 6;
		int actual = matrixManager.getAverage(matrix);
		assertEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetAverageWithNull() {
		int actual = matrixManager.getAverage(null);
	}
	
	@Test (expected = IllegalArgumentException.class)	
	public void testGetAverageWithNotSquareMatrix() {
		int[][] matrix = {{ 2, 4, 5, 1 },
				  { 6, 10, 3, 2 },
				  { 5, 4, 3, 3 }};
		int actual = matrixManager.getAverage(matrix);
	}
	
	
	

}
