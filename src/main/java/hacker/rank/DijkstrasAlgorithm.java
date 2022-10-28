package hacker.rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {


	public static void main(String[] args) {

		Solution solution = new Solution();
		int[][] request = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
		System.out.println(solution.minCost(request));
	}

	public static class Solution {

		private static final int RIGHT_SIGN = 1;
		private static final int LEFT_SIGN = 2;
		private static final int UP_SIGN = 3;
		private static final int DOWN_SIGN = 4;
		private static final int COST_FOR_CHANGING_VALUE_OF_SIGN = 1;
		private static final int[][] MOVES = {{0, 1, RIGHT_SIGN}, {0, -1, LEFT_SIGN}, {1, 0, UP_SIGN}, {-1, 0, DOWN_SIGN}};

		private int rows;
		private int columns;

		public int minCost(int[][] grid) {
			rows = grid.length;
			columns = grid[0].length;
			return dijkstraSearchForMinCostPath(grid);
		}

		private int dijkstraSearchForMinCostPath(int[][] grid) {

			PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
			int[][] minCostPath = new int[rows][columns];
			initializeMinCostPath(minCostPath);

			minCostPath[0][0] = 0;
			minHeap.add(new int[]{0, 0, 0});

			while (!minHeap.isEmpty()) {
				int[] point = minHeap.poll();

				for (int[] move : MOVES) {
					int nextRow = point[0] + move[0];
					int nextColumn = point[1] + move[1];

					if (pointIsInGrid(nextRow, nextColumn)) {
						int costFromCurrentToNextPoint = grid[point[0]][point[1]] != move[2] ? COST_FOR_CHANGING_VALUE_OF_SIGN : 0;
						int costFromStartToNextPoint = minCostPath[point[0]][point[1]] + costFromCurrentToNextPoint;

						if (costFromStartToNextPoint < minCostPath[nextRow][nextColumn]) {
							minCostPath[nextRow][nextColumn] = costFromStartToNextPoint;
							minHeap.offer(new int[] {nextRow, nextColumn, costFromStartToNextPoint});
						}
					}
				}
			}
			return minCostPath[rows - 1][columns - 1];
		}

		private void initializeMinCostPath(int[][] minCostPath) {
			for (int row = 0; row < rows; ++row) {
				Arrays.fill(minCostPath[row], Integer.MAX_VALUE);
			}
		}

		private boolean pointIsInGrid(int row, int column) {
			return row < rows && row >= 0 && column < columns && column >= 0;
		}
	}
}
