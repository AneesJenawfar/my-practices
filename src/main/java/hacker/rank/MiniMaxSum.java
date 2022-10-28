package hacker.rank;

import java.util.*;

public class MiniMaxSum {
	public static void main(String[] args) {
		MiniMaxSum.miniMaxSum(Arrays.asList( 256741038, 623958417, 467905213, 714532089, 938071625));

	}

	public static void miniMaxSum(List<Integer> arr) {
		// Write your code here
		int min = arr.stream().min(Integer::compare).get();
		int max = arr.stream().max(Integer::compare).get();
		int indexMax = arr.indexOf(max);
		int indexMin = arr.indexOf(min);
		Set<Integer> set = new HashSet<>(arr);
		List<Integer> maxSum = new ArrayList<>(arr);
		maxSum.remove(indexMin);
		List<Integer> minSum = new ArrayList<>(arr);
		minSum.remove(indexMax);
		System.out.println(minSum.stream().mapToLong(Integer::longValue).sum()
			+" "
			+maxSum.stream().mapToLong(Integer::longValue).sum());
	}
}
