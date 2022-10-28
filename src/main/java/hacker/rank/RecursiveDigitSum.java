package hacker.rank;

import java.util.*;

public class RecursiveDigitSum {
	static class SinglyLinkedListNode {
		public String data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(String nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}
	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(String nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}
			this.tail = node;
		}
	}
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {



		String alph = "123456788765432";
//		System.out.println(superDigit(alph, 10000));
		int q = scanner.nextInt();
		Queue<String> list = new LinkedList<>();
		while (q > 0) {
			String[] str = scanner.nextLine().split(" ");
			switch (str[0]) {
				case "1":
					list.add(str[1]);
					break;
				case "2":
					list.poll();
					break;
				case "3":
					System.out.println(list.peek());
					break;
			}
			q--;
		}
	}

	public static int superDigit(String n, int k) {
		long sum  = splittedSum(n);
		sum = sum * k;

		return (int) recursiveSum(sum);
	}

	public static long recursiveSum(long sum){
		if (sum < 10) {
			return sum;
		}
		long newSum = splittedSum(String.valueOf(sum));

		return recursiveSum(newSum);
	}

	public static long splittedSum(String n) {
		String[] splitted = n.split("");
		long sum = 0;
		int i = 0;
		while (i < splitted.length) {
			String s = splitted[i];
			i++;
			if (n == null) continue;
			try {
				sum += Integer.parseInt(s);
			} catch (Exception e) {
				continue;
			}

		}
		return sum;
	}

	public static int truckTour(List<List<Integer>> petrolpumps) {
		// Write your code here
		int sum = 0;
		int diff = 0;

		int  start = 0;

		for(int i =0 ; i< petrolpumps.size(); i++){
			sum += petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
			if(sum < 0){
				start = i+1;
				diff += sum;
				sum = 0;
			}
		}

		return sum + diff > 0 ? start : -1 ;
	}

}
