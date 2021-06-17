/**
 * https://www.hackerrank.com/challenges/minimum-time-required/problem
 */
package hackerrank.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MinDaysMachine {

    static int minDays(long[] machines, int goal) {
        Arrays.sort(machines);
        long max = machines[machines.length - 1];
        long minDays = 0;
        /*
          Step one find the MaxBoundary.
          Suppose all the machine take max Days to achieve goal then the goal can be achieved by
          (goal/machinesCnt) * maxDays
         */
        long maxDays = max*goal;
        long result = -1;
        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;

            //calculate current goal which will be currentDays/eachMachine
            long currGoal = 0;
            for (long machine : machines) {
                currGoal += mid / machine;
            }

            //But if goal is less than current mid Boundary? the check the first half to find the days
            if (currGoal < goal) {
                minDays = mid+1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        File files = new File("src/main/resources/MinDaysMachine/input/");
        if (files.exists()) {
            for(File file: files.listFiles()){
                System.out.println("---------File Name:"+file.getName());
                try {
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNext()) {
                        int length = scanner.nextInt();
                        long[] machines = new long [length];
                        int goal = scanner.nextInt();
                        System.out.println("Goal:"+goal);
                        for(int i=0;i<length;i++) {
                            machines[i] = scanner.nextInt();
                        }
                        System.out.println("Machines:"+Arrays.toString(machines));
                        System.out.println("Min Days required is:"+minDays(machines, goal));
                    }
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
