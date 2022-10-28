package hacker.rank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CamelCase {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		while (true) {
			String value = bufferedReader.readLine().trim();

			String result = CamelCase.camelCase(value);

			bufferedWriter.write(result);
		}

//		bufferedReader.close();
//		bufferedWriter.close();
	}

	public static String camelCase(String value) {
		String[] arr = value.split(";");
		switch (arr[0]) {
			case "C":

		}
		return null;
	}

}
