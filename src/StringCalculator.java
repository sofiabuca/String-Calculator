/**
 * Purpose:           Part1. String Calculator Test <br />
 * Data Submitted:    10/3/2024 <br />
 * Assignment Number: Assigment 1 <br />
 * Course Name:       COSC 603 <br />
 * Instructor Name:   Michael Grzesina <br />
 * File Path:         StringCalculator.java<br />
 * @author Laura Sofia Buitrago Cardona <br />
 * @version 1.0.0 <br />
 */
import java.util.ArrayList;
import java.util.List;
public class StringCalculator
{
    /**
     * Add Method: Generate the sum of numbers
     * @param numbers
     * @return
     */
    public static int add (String numbers){

        //Declare variables
        String delimiter = ",|n";
        String numbersWithOutDelimiter = numbers;

        //Check with which format start the string
        if (numbers.startsWith("//["))
        {
            //Call the method multipleDelimiter
            delimiter = multipleDelimiter(numbersWithOutDelimiter);

            //Return
            return add(numbersWithOutDelimiter, delimiter);
        }

        //Check with which format start the string
        if (numbers.startsWith("//")){
            int delimiterIndex = numbers.indexOf("//") + 3;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbersWithOutDelimiter = numbers.substring(numbers.indexOf("\n"));
        }

        //return
        return add(numbersWithOutDelimiter, delimiter);
    }

    /**
     * Add
     * @param numbers : String of numbers
     * @param delimiter : delimiter
     * @return
     */
    private static int add(final String numbers, final String delimiter){
        //Declare variables
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negativeNumbers = new ArrayList<>();

        //For loop
        for (String number : numbersArray) {

            //Check if is not empty
            if (!number.trim().isEmpty()) {

                //check if is a number
                if(isInteger(number)) {
                    int numberInt = Integer.parseInt(number.trim());

                    //check if is negative
                    if (numberInt < 0) {
                        negativeNumbers.add(numberInt);
                    }

                    //check if is less than 1000
                    if (numberInt <= 1000) {
                        returnValue += numberInt;
                    }
                }
            }
        }

        //Exception for negatives
        if(negativeNumbers.size() > 0){
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }

        //return
        return returnValue;
    }

    /**
     * multipleDelimiter: Return a String with the multiple delimiters
     * @param numbers
     * @return
     */
    private static String multipleDelimiter(String numbers){
        //Declare variables
        String delimiter;
        String [] arrDelimiter;
        ArrayList listDelimiters = new ArrayList<>();

        //Determinate the limiters
        int delimiterIndex1 = numbers.indexOf("//[") + 3;
        int delimiterIndex2 = numbers.indexOf("\n") ;

        delimiter = numbers.substring(delimiterIndex1, delimiterIndex2);
        arrDelimiter = delimiter.split("");

        //For loop for add to the arrayList
        for (int i = 0; i < arrDelimiter.length; i++){
            if( (!arrDelimiter[i].equals("[")) && (!arrDelimiter[i].equals("]"))  ){
                listDelimiters.add(arrDelimiter[i]);
            }
        }

        //Convert the arraylist in string
        listDelimiters.add("\n");
        delimiter = String.join(",", listDelimiters);
        delimiter = delimiter.replace(",", "|");

        //return
        return delimiter;
    }

    /**
     * isInteger: Check if the value is a integer
     * @param sNum
     * @return
     */
    private static boolean isInteger(String sNum){
        Boolean isInteger;
        try {
            Integer.parseInt(sNum);
            isInteger = true;
        } catch (NumberFormatException e) {
            isInteger = false;
        }
        return isInteger;
    }


}
