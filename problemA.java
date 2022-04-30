package se.demo.applianceservice.error;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> milesDriven = new ArrayList<>();

        String input;
        int n;

        while(!(input = scanner.nextLine()).equals("-1")){
            n = Integer.parseInt(input);

            int prevT = 0;
            int totalMiles = 0;

            for(int i = 0; i < n; i++) {
                input = scanner.nextLine();

                String[] values = input.split(" ");
                int s = Integer.parseInt(values[0]);
                int t = Integer.parseInt(values[1]);

                totalMiles += s*(t - prevT);
                prevT = t;
            }
            milesDriven.add(totalMiles + " miles");
        }

        for(String miles : milesDriven) {
            System.out.println(miles);
        }
    }
}

/*
Problem A
Bill and Ted are taking a road trip. But the odometer in their car is broken, so they don’t know how many miles they have driven. Fortunately, Bill has a working stopwatch, so they can record their speed and the total time they have driven. Unfortunately, their record keeping strategy is a little odd, so they need help computing the total distance driven. You are to write a program to do this computation.

For example, if their log shows

Speed in miles per hour

Total elapsed time in hours







this means they drove  hours at  miles per hour, then  hours at  miles per hour, then  hour at  miles per hour. The distance driven is then  miles. Note that the total elapsed time is always since the beginning of the trip, not since the previous entry in their log.

Input
The input consists of one or more data sets (at most ). Each set starts with a line containing an integer , , followed by  pairs of values, one pair per line. The first value in a pair, , is the speed in miles per hour and the second value, , is the total elapsed time. Both  and  are integers,  and . The values for  are always in strictly increasing order. A value of  for  signals the end of the input.

Output
For each input set, print the distance driven, followed by a space, followed by the word “miles”.

Sample Input 1	Sample Output 1
3
20 2
30 6
10 7
2
60 1
30 5
4
15 1
25 2
30 3
10 5
-1
170 miles
180 miles
90 miles
 */