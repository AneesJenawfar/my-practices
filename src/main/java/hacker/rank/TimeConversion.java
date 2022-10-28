package hacker.rank;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class TimeConversion {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
//		Integer int1 = 1233;
//		Integer int2 = 1233;
//
//		System.out.println(int1 == int2);
//		System.out.println(int1.equals(int2));
//
//		String str1 = new String("11111");
//		String str2 = new String("11111");
//
//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));

//		System.out.println(caesarCipher("middle-Outz!", 2));
//		String alph = "abcdefghijklmopqrstuvwxyz";
//		System.out.println(isBalanced("{[()]}"));

		Stack<String> lastActions = new Stack<>();
		int q = scanner.nextInt();
		StringBuilder sb = new StringBuilder();
		while (q >=0) {
			String[] splitted = scanner.nextLine().split(" ");
			switch(splitted[0]) {
				case "1":
					lastActions.push(sb.toString());
					sb.append(splitted[1]);
					break;
				case "2":
					lastActions.push(sb.toString());
					int k = Integer.parseInt(splitted[1]);
					sb = new StringBuilder(sb.substring(0, sb.length()-k));
					break;
				case "3":
//					lastActions.push(sb.toString());
					int l = Integer.parseInt(splitted[1]);
					System.out.println(sb.charAt(l-1));
					break;
				case "4":
					sb = new StringBuilder(lastActions.pop());
					break;
			}
			q--;
		}
	}

	public static final Map<String, String> map = Map.of(
		")", "(",
		"}", "{",
		"]", "["
	);
	public static String isBalanced(String str) {
		String[] splitted = str.split("");
		Stack<String> bracketStack = new Stack<>();
		for(String s: splitted) {
			String open = map.get(s);
			if (bracketStack.isEmpty() && open != null) {
				return "NO";
			}
			if (open == null) {
				bracketStack.push(s);
			} else {
				if (Objects.equals(bracketStack.peek(), open)) {
					bracketStack.pop();
				} else {
					return "NO";
				}
			}
		}
		return "YES";
	}

	public static String caesarCipher(String s, int k) {
		// Write your code here
		String alph = "abcdefghijklmopqrstuvwxyz";
		String response = "";
		for (int i= 0; i < s.length(); i++) {
			char c = s.charAt(i);
			String str = String.valueOf(c);
			if (c == '-') {
				response += "-";
				continue;
			}
			int indx = alph.indexOf(str.toLowerCase());

			response += str == str.toLowerCase() ? alph.charAt((indx + k)%26) : String.valueOf(alph.charAt((indx + k)%26)).toUpperCase();
		}
		return response;
	}
}
