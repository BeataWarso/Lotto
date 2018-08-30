import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 
LOTTO SIMULATOR
With scanner you can put numbers in.
You can type  only numbers in range 1-49 no duplication.
An error will pop out, when you type:
- some number out of range,
- or type letter, 
- or, you duplicate number that you`ve already typed

Random generator is in too.
- with it you get random numbers
- without duplication, because its in HashSet
- in range 1-49

Program, check if numbers witch you put, are same as random.
tells you how many you guess, or if you win something.

 */

public class Lotto {

	private static List<Integer> UsersNumbers = new ArrayList<>();
	private static Set<Integer> RandomNumbers = new HashSet<>();
	private static final int RANGE1 = 1;
	private static final int RANGE2 = 49;
	private static final int SIZE = 6;

	public static <T> void main(String[] args) {

		System.out.println("Welcome to our lotto game!");
		System.out.println("Please type your 6 lucky numbers in range 1-49:");
		int count = 0;

		while (count < SIZE) {
			try {

				Scanner input = new Scanner(System.in);
				int luckyNumbers = input.nextInt();
				if (luckyNumbers > RANGE2 || luckyNumbers < RANGE1) {
					System.out.println("You`re out of range!");
					count--;
				}

				else if (UsersNumbers.contains(luckyNumbers)) {
					System.out.println("You`ve already typed this number!");
					count--;
				}
				
		
				else
					UsersNumbers.add(luckyNumbers);
					count++;
			}

			catch (InputMismatchException e) {
				System.out.println("Please, type only numbers");

			}
		}

		System.out.println("You choose these numbers" + UsersNumbers + "\n");

		Random random = new Random();
		assert RandomNumbers.size() == SIZE;
		while (RandomNumbers.size() < SIZE) {
			while (RandomNumbers.add(random.nextInt(RANGE2)) != true);

		}

		System.out.println("Lucky numbers are: " + RandomNumbers+ "\n");

		List<T> CommonNumbers = (List<T>) RandomNumbers.stream().filter(UsersNumbers::contains)
				.collect(Collectors.toList());

		int numbers = CommonNumbers.size();

		switch (numbers) {
		case 0:
			System.out.println("Sorry, you lost - didnt guess any number:( ");
			break;
		case 1:
			System.out.println("You guessed 1 number!" + CommonNumbers);
			break;
		case 2:
			System.out.println("You guessed 2 numbers! " + CommonNumbers);
			break;
		case 3:
			System.out.println("You guessed 3 numbers! " + CommonNumbers + " and You win 10 zł!");
			break;
		case 4:
			System.out.println("You guessed 4 numbers! " + CommonNumbers + " and You win 1000 zł!");
			break;
		case 5:
			System.out.println("You guessed 5 numbers! " + CommonNumbers + " and You win 10 000 zł!");
			break;
		default:
			System.out.println("Congratulations! You win lots of money!!! You guessed 6 numbers!");
			break;
		}


	}
}




// I`ve tried to generete numbers another way,
// it works, but, there were duplicates in randoms

// public static <T> void generator() {
// int limit = 6;
// int min =1;
// int max = 49;
// IntStream randoms= new Random().ints(limit, min, max);
//
// int[] numbers = randoms.toArray();
// for(int n:numbers){
// System.out.println(n);
// }
// }
//

