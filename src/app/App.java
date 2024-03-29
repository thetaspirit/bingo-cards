package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

public class App {
	static PrintStream output;
	static Random random = new Random();

	static String[] answers = { "honey pot", "increased", "Australia", "the world", "The Netherlands", "America",
			"reduce", "decreased", "harm-reduction", "Not in our neighborhood", "encourage", "opioids", "less", "crime",
			"high-risk", "died", "overdosed", "mental health care", "diseases such as HIV", "stigma", "approved",
			"safe place" };

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 0; i < 7; i++) {
			printFile(i);
		}
	}

	public static void printFile(int num) throws FileNotFoundException {
		output = new PrintStream(new File("output" + num + ".txt"));
		ArrayList<Integer> used = new ArrayList<Integer>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int index = random.nextInt(22);
				if (!used.contains(index)) {
					used.add(index);
					output.printf("%-25s", answers[index]);
				} else {
					j--;
				}

			}
			for (int returns = 0; returns < 5; returns++) {
				output.println();
			}
		}

		output.close();
		System.out.println("hello world");
	}
}