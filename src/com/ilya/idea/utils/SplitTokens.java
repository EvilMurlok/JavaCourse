/*
Problem 1 The input of the program receives a line
(Example: "aa aaa aa bb bbb bbbb bb ddd uuu iii ooo")
It is necessary to parse the string into tokens and draw the following output aa: 2 aaa: 1 bb: 2 ... and so on.
Where the digit after the colon denotes the number of occurrences of this token in the string

!!! Any separator, it can also consist of any number of characters !!!

Task 2 For the same string, remove all duplicate values and display them in their original order.
 */

package com.ilya.idea.utils;

import java.util.*;

public class SplitTokens {
    private String userInput;
    private String userDelimiter;
    private ArrayList<String> tokens;
    private  final HashMap<String, Integer> finalStatistics;

    private ArrayList<String> createTokens(){
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(this.userInput.split(this.userDelimiter)));
        tempList.removeAll(Collections.singleton(""));
        return tempList;
    }

    public SplitTokens(String userInput, String userDelimiter) {
        this.userInput = userInput;
        this.userDelimiter = userDelimiter;
        this.tokens = createTokens();
        this.finalStatistics = new HashMap<>();
    }

    public SplitTokens(String userInput){
        this(userInput, "\\s");
    }

    public HashMap<String, Integer> getFinalStatistics(){
        return this.finalStatistics;
    }

    public void changeData(String newUserInput, String newUserDelimiter){
        this.userInput = newUserInput;
        this.userDelimiter = newUserDelimiter;
        this.tokens = createTokens();
        this.finalStatistics.clear();
    }

    public void changeData(String newUserInput){
        this.changeData(newUserInput, "\\s");
    }

    public void createStatistics(){
        for (String tempString: this.tokens){
            Integer countOfString = this.finalStatistics.get(tempString);
            if (countOfString == null){
                this.finalStatistics.put(tempString, 1);
            }
            else{
                this.finalStatistics.put(tempString, ++countOfString);
            }
        }
    }


    /*
        There are two some serious assumptions:
            - if delimiter was created like "\\s" I've decided to replace it with one space;
            - this parser can't support real regular expressions, beside escaping with two backslashes
    */
    private String getHumanDelimiter(){
        if (this.userDelimiter.equals("\\s")){
            return " ";
        }
        else{
            return this.userDelimiter.replace("\\", "");
        }
    }

    public String deleteAllDuplicates(){
        String finalString = "";
        String humanDelimiter = getHumanDelimiter();
        HashSet<String> tempSet = new HashSet<>();
        for (String tempString: this.tokens){
            if (!tempSet.contains(tempString)){
                finalString += tempString + humanDelimiter;
            }
            tempSet.add(tempString);
        }
        return finalString;
    }
}