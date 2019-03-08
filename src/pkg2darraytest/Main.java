/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2darraytest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {

    public static int calculateHourglass(int x, int y, int[][] arr) {
        System.out.println("Begin calculateHourglass cycle at " + y + "," + x);
        int count = 0;
        for (int y2 = y; y2 <= y+2; y2++) {
            //System.out.println("y2 == " + y2);
            for (int x2 = x; x2 <= x+2; x2++) {
                //System.out.println("x2 == " + x2);
                System.out.println(x2 + "," + y2 + " == " + arr[y2][x2]);
                if ((y2 == y+1) && (x2 == x || x2 == x+2)) {
                    count += 0;
                    //System.out.println("Count did not change");
                } else {
                    count += arr[y2][x2];
                    //System.out.println("Count == " + count);
                }
            }
        }
        return count;       
    }

    public static int findMaxHourglass(int[][] arr) {
        int max = 0;
        int current = 0;
        for (int y = 0; y <= 3; y++) {
            for (int x = 0; x <= 3; x++) {
                current = calculateHourglass(x,y,arr);
                System.out.println("Current hourglass size: " + current);
                if (current > max || (x == 0 && y == 0) ) {
                    max = current;
                }
                current = 0;
            }
        }
        return max;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int biggestHourglass = 0;
        
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        
        biggestHourglass = findMaxHourglass(arr);
        System.out.println(biggestHourglass);
    }
}
