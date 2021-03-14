package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctCountLetters {
    private String str;
    private int lineNumber = 1;
    private HashMap<Character, Integer> hashMap= new HashMap<>();
    private ArrayList<Integer> numOfLetters = new ArrayList<>();
    private ArrayList<Integer> controlList = new ArrayList<>();

    private void findNumberOfLetters() {
        for (int i = 0; i < str.length(); i++) {
            if(!hashMap.containsKey(str.charAt(i))) // if hashMap does not contains the letter, add the letter to hashMap with count 1.
            {
                hashMap.put(str.charAt(i), 1);
            }
            else // if hashMap contains the letter, increment the count by 1.
            {
                hashMap.put(str.charAt(i), hashMap.get(str.charAt(i))+1);
            }
        }

        for (int value : hashMap.values()) { // create a integer list includes values of hashMap
            numOfLetters.add(value);
        }
    }

    public void calculate() {
        //clear the variables and the lists for next lines
        int result = 0;
        hashMap.clear();
        numOfLetters.clear(); // numOfLetters contains number of letters from the line
        controlList.clear(); // controlList contains the unique number of letters

        findNumberOfLetters();

        for (int count : numOfLetters) {
            for (int i = count; i > 0 ; i--) { // starting the count of first letter, control the controlList elements
                if(controlList.contains(i)) { // if controlList contains the number, that means we must delete one letter
                    result++; // we increment result while deleting letter
                }
                else {
                    controlList.add(i); // if the controlList does not contain the number, we dont need delete letter
                    break; // when we find the number that controlList does not contain, it means we find the unique number for a letter.
                }
            }
        }

        System.out.println(lineNumber + "- " + result); // print the result
        lineNumber++;
    }

    public void setStr(String s) throws Exception { // checking constraints in setter
        if(s.length() < 1 || s.length() > 300000){
            throw new Exception("Input lines in text file must be contains between 1 and 300000 characters.");
        }

        for (int i = 0; i < s.length(); i++) {
            if(!Character.isLetter(s.charAt(i)) || !Character.isLowerCase(s.charAt(i))) {
                throw new Exception("Input lines in text file must be consists only lowercase letters. (a-z)");
            }
        }

        this.str = s;
    }
}
