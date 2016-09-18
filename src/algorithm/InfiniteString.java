package algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by abdaniel on 9/10/16.
 */
public class InfiniteString {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _coordinates;
        try {
            _coordinates = in.nextLine();
        } catch (Exception e) {
            _coordinates = null;
        }

        int _remove;
        _remove = Integer.parseInt(in.nextLine().trim());

        res = improbabilityCalculator(_coordinates, _remove);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    public static String maxSubArray(String str, int size) {
        int[] num = new int[str.length()];
        int maxStartIndex=0;
        int maxSum = Integer.MIN_VALUE;

        int cumulativeSum= 0;
        int maxStartIndexUntilNow=0;


        for (int i = 0; i < num.length; i++) {

            num[i] = str.charAt(i) - '0';
            cumulativeSum+=num[i];

            if(cumulativeSum>maxSum){
                maxSum = cumulativeSum;
                maxStartIndex=maxStartIndexUntilNow;
            }
            else if (cumulativeSum<0){
                maxStartIndexUntilNow=i+1;
                cumulativeSum=0;
            }
        }

        return new StringBuilder(str).delete(maxStartIndex, maxStartIndex + size + 1).toString();
    }

    private static String improbabilityCalculator(String coordinates, int remove) {
        int originalLength = coordinates.length();
        int neededLength = originalLength - remove;
        if(remove == 0)
            return coordinates;
        if(coordinates.length() < remove)
            return "0";
        int startIndex = findStartingPoint(coordinates.substring(0, coordinates.length() - remove + 1));
        coordinates = coordinates.substring(startIndex, coordinates.length());
        if(neededLength == coordinates.length()) return coordinates;
        return maxSubArray(coordinates, coordinates.length() - neededLength);
    }

    private static int findStartingPoint(String str) {
        int[] num = new int[str.length()];

        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = 0; i < str.length(); i++){
            num[i] = str.charAt(i) - '0';
            if(num[i] < min)    {
                min = num[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
