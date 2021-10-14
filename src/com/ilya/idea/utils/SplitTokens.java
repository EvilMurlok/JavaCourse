/*
Задача 1 На вход программы поступает строка
(Пример: «aa aaa aa bb bbb bbbb bb ddd uuu iii ooo»)
Необходимо распарсить строку на токены и сделать следующий вывод аа:2 aaa:1 bb:2 … и т.д.
Где цифра после двоеточия обозначает количество появлений этого токена в строке

!!! Разделитель любой, он также может состоять из любого количества символов !!!

Задача 2 Для такой же строки удалить все повторяющиеся значения и вывести в исходном порядке.
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

    // DELETE THIS (IT WAS FOR DEBUG!)
    public ArrayList<String> getTokens(){
        return this.tokens;
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