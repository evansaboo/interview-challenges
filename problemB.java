package se.demo.applianceservice.error;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problemB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] values = input.split(" ");

        double Q = Integer.parseInt(values[0]);
        double M = Integer.parseInt(values[1]);
        double S = Integer.parseInt(values[2]);
        double L = Integer.parseInt(values[3]);

        double L1 = Math.ceil(L / M) * Q;
        double L2 = M - (L % M);

        double S1 = L2 < M ? (S - (L2 * Q)) : S;
        double S2 = S1 < 0 ? 0 : S1;
        double S3 = Math.ceil(S2 / M);

        double minTime = L1 + Math.ceil(S3);

        System.out.println((int) minTime);
    }
}

/*
Problem B
/problems/smallschedule/file/statement/en/img-0001.jpg

Everybody is into cloud computing these days, so quite a few different business models are being experimented with. You are trying a very simple one: you sell time on your machines in one of two batches called slots. A customer can buy one second of CPU time or  seconds for some integer .

Each time slot a customer purchases must be completed on a single machine, but you get to decide how to allocate the purchased time slots between machines.

After coming back from a long vacation, you see that all of your machines are idle and a variety of orders have come in. To keep customers happy, you must decide how to distribute these requests between machines in a way that minimizes the time when the purchased time slots are finally all completed.

What is the smallest amount of time in which you can complete all of the purchased time slots?

Input
The input consists of a single line containing four integers  (), which is the time needed to complete the longer batches,  (), which is the number of machines owned by your company,  (), which is the number of 1-second time slots purchased, and  (), which is the number of -second time slots purchased.

Output
Display the smallest amount of time in which you can complete all of the purchased time slots.

Sample Input 1	Sample Output 1
2 4 3 6
4
Sample Input 2	Sample Output 2
3 4 3 5
6
Sample Input 3	Sample Output 3
10 2 0 1
10
 */
