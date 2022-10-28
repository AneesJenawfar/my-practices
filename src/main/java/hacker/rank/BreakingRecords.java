package hacker.rank;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BreakingRecords {


	public static void main(String[] args) {
		String sdd = "*|*|*|";

		System.out.println(calculateImbalance(Arrays.asList(4,4,1,3,2), 0, 0, 0));
	}


	private static long calculateImbalance(List<Integer> rank, int start, int end, long total) {
		if (start == rank.size() || end == rank.size() || start == end) {
			return total;
		}

		List<Integer> subArr = rank.subList(start, end);
		if (!subArr.isEmpty() && subArr.size() >1) {
			Collections.sort(subArr);
			for (int i = start; i < end; i++) {
				if (i < end-1 && (subArr.get(i+1) - subArr.get(i)) > 1) {
					total++;
				}
			}
		}

		if (end == rank.size()-1) {
			total = calculateImbalance(rank, start+1, start+1, total);
		} else {
			total = calculateImbalance(rank, start, end + 1, total);
		}

		return total;
	}

}
