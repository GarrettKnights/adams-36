/*
 *  UCF COP3330 Fall 2021 Assignment 36 Solution
 *  Copyright 2021 Garrett Adams
 */

package Exercise36;

//Imports all java util
import java.util.*;
//Imports math
import static java.lang.Math.*;

public class Solution36 {
    public static void main(String[] args) throws NumberFormatException {
        //Declares all the variables that we will be needing
        ArrayList<Integer> ArrayListOfNumbers = new ArrayList<>();
        String UserNumber = "";
        double IntegerNum;
        double Standard;
        double RoundStandard;
        double MaximumFinal;
        double MinimumFinal;
        double AverageFinal;
        //Sets up our Scanner
        Scanner ScanWord = new Scanner(System.in);

        //While the user number isnt = done
        while(!UserNumber.equals("done"))
        {
            //Prompts user to enter a number
            System.out.print("Enter a number: ");
            //Scans user ScanWord to UserNumber
            UserNumber = ScanWord.next();
            //If user number is done will end loop
            if (UserNumber.equals("done")) {
            }
            //If user number is not done, tries to change to int and adds to ArrayList
            else {
                IntegerNum = Integer.parseInt(UserNumber);
                ArrayListOfNumbers.add((int) IntegerNum);
            }
        }

        //Prints out all of the numbers
        StringJoiner joiner = new StringJoiner(",");
        for (Integer ArrayListOfNumber : ArrayListOfNumbers) {
            String s = String.valueOf(ArrayListOfNumber);
            joiner.add(s);
        }
        System.out.println("Numbers: "+ joiner.toString());
        //Saves average to AverageFinal and prints out the average
        AverageFinal = average(ArrayListOfNumbers);
        System.out.println("The average is "+ AverageFinal);
        //Saves minimum to MinimumFinal and prints out the minimum
        MinimumFinal = min(ArrayListOfNumbers);
        System.out.println("The minimum is "+ MinimumFinal);
        //Saves maximum to MaximumFinal and prints out the maximum
        MaximumFinal = max(ArrayListOfNumbers);
        System.out.println("The maximum is "+ MaximumFinal);
        //Saves standard deviation to RoundStandard and prints out the standard deviation
        Standard = std(ArrayListOfNumbers);
        RoundStandard = Math.round(Standard*100.0)/100.0;
        System.out.println("The standard deviation is "+ RoundStandard);


    }

    //Function for finding standard deviation
    public static double std(ArrayList<Integer> ArrayListOfNumbers) {
        //Sets the average to AverageofArrayList
        double AverageofArrayList = average(ArrayListOfNumbers);

        //Sets the total to TotalOfArrayList
        double TotalOfArrayList = ArrayListOfNumbers.stream().mapToDouble(IntegerNum -> IntegerNum).map(IntegerNum -> pow((IntegerNum - AverageofArrayList), 2)).sum();

        double StandardDeviation;
        //Calculates the Standard Deviation
        StandardDeviation = sqrt(TotalOfArrayList/ArrayListOfNumbers.size());
        //Returns the Standard Deviation
        return StandardDeviation;
    }

    public static double max(ArrayList<Integer> ArrayListOfNumbers) {
        //starts by setting max to the first element of array
        double MaximumValue= ArrayListOfNumbers.get(0);

        //For loop to figure out maximum
        for (int i = 0, numbersSize = ArrayListOfNumbers.size(); i < numbersSize; i++) {
            double IntegerNum = ArrayListOfNumbers.get(i);
            //If current max is less then element, make element new max
            if (MaximumValue < IntegerNum)
                MaximumValue = IntegerNum;
        }
        //Returns the max
        return MaximumValue;
    }

    //Function for finding average
    public static double average(ArrayList<Integer> ArrayListOfNumbers) {
        //Finds the total
        double total = ArrayListOfNumbers.stream().mapToDouble(IntegerNum -> IntegerNum).sum();
        //Returns the average
        return (double)(total)/ArrayListOfNumbers.size();
    }

    //Function for finding min
    public static double min(ArrayList<Integer> ArrayListOfNumbers) {
        //Starts off by setting min to first element of array
        double MinimumValue= ArrayListOfNumbers.get(0);
        //FOr loop that goes through each element of array
        for (int i = 0, numbersSize = ArrayListOfNumbers.size(); i < numbersSize; i++) {
            double IntegerNum = ArrayListOfNumbers.get(i);
            //If current Min is greater then next element, set next element to new min
            if (MinimumValue > IntegerNum)
                MinimumValue = IntegerNum;
        }
        //Returns the Minimum
        return MinimumValue;
    }
}


