import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Facebook Hacker Cup 2020: Qualification Round
 * Problem A: Travel Restrictions
 *
 * Time complexity:
 * Worst-case: (n^2)
 * Best-case: (n^2)
 *
 * Space complexity:
 * Worst-case: (n)
 * Best-case: (n)
 */

public class Solution {
    /**
     * Function that reads the input file containing incoming and outgoing restrictions of all airports and prints
     * all possible cities an aircraft can go to given its source city.
     * @param parameters Parameters that were passed with the "run" command.
     * @throws IOException In case there was trouble opening the files.
     */
    public static void main(final String[] parameters) throws IOException {
        Scanner input = new Scanner(new File("C:\\Users\\Saksham\\Desktop\\Java\\Solution\\src\\input.txt"));
        PrintWriter output = new PrintWriter("C:\\Users\\Saksham\\Desktop\\Java\\Solution\\src\\output.txt");
        int totalCases = input.nextInt();

        for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
            int totalCities = input.nextInt();
            char[] incoming = input.next().toCharArray();
            char[] outgoing = input.next().toCharArray();

            output.println("Case #" + caseNumber + ": ");

            for (int cityNumber = 0; cityNumber < totalCities; cityNumber++) {
                char[] result = new char[totalCities];
                result[cityNumber] = 'Y';
                int leftIndex = cityNumber - 1;
                int rightIndex = cityNumber + 1;

                while (leftIndex >= 0) {
                    if (outgoing[leftIndex + 1] == 'Y' && incoming[leftIndex] == 'Y') {
                        result[leftIndex--] = 'Y';
                    } else {
                        break;
                    }
                }

                while (leftIndex >= 0) {
                    result[leftIndex--] = 'N';
                }

                while (rightIndex < result.length) {
                    if (outgoing[rightIndex - 1] == 'Y' && incoming[rightIndex] == 'Y') {
                        result[rightIndex++] = 'Y';
                    } else {
                        break;
                    }
                }

                while (rightIndex < result.length) {
                    result[rightIndex++] = 'N';
                }

                output.println(new String(result));
            }
        }

        output.close();
    }
}
