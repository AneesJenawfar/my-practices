package hacker.rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlusMinus {

	public static void main(String[] args) {

//		PlusMinus.plusMinus(43, Arrays.asList( 55, 48, 48, 45, 91, 97, 45, 1, 39, 54, 36, 6, 19, 35, 66, 36,
//			72, 93, 38, 21, 65, 70, 36, 63, 39, 76, 82, 26, 67, 29, 24, 82, 62, 53, 1, 50, 47, 65, 67, 19, 66,
//			90, 77));
		PlusMinus.plusMinus(6, Arrays.asList( -4, 3, -9, 0, 4, 1));

	}
	public static void plusMinus(int n, List <Integer> arr) {
		// Write your code here
		int pos = (int) arr.stream().filter(integer -> integer> 0).count();
		int neg = (int) arr.stream().filter(integer -> integer< 0).count();
		int zero = (int) arr.stream().filter(integer -> integer== 0).count();

		System.out.println(PlusMinus.getRatioWithSixDecimal(n, pos, "0.", 0));
		System.out.println(PlusMinus.getRatioWithSixDecimal(n, neg, "0.", 0));
		System.out.println(PlusMinus.getRatioWithSixDecimal(n, zero, "0.", 0));
	}

	private static String getRatioWithSixDecimal(int n, int count, String value, int decimals) {
		if (decimals ==0 && count == 0) return "0.000000";
		if (decimals == 0 && n == count) return "1.000000";
		if (decimals == 6) return value;
		decimals++;
		count = count*10;
		int lastDecimal = count / n;
		count = count % n;
		if (decimals == 6 && count*10/n >= 5) lastDecimal++;
		return PlusMinus.getRatioWithSixDecimal(n, count, value + lastDecimal, decimals);
	}

	private static Map<String, Integer> getStatics(int n, List <Integer> arr) {
		// Write your code here

		int i = 0;
		Map<String, Integer> statics = new HashMap<String, Integer>() {{put("p", 0);put("n", 0);put("z", 0);}};
		while (i<n) {
			if (arr.get(i) > 0) {
				statics.put("p", statics.get("p")+1);
			} else if (arr.get(i) < 0) {
				statics.put("n", statics.get("n")+1);
			} else {
				statics.put("z", statics.get("z")+1);
			}
			i++;
		}
		return statics;
	}
}
