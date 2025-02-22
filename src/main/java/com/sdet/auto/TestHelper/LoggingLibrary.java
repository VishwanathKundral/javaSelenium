package com.sdet.auto.TestHelper;

public class LoggingLibrary {

    public static boolean CompareResult(String actual, String expected){

        if(actual.equals(expected)){
            InOutLibrary.writeLine(String.format("PASS: Actual(%s) | Expected(%s)", actual, expected));
            return true;
        }
        else{
            InOutLibrary.writeLine(String.format("FAIL: Actual(%s) | Expected(%s)", actual, expected));
           return false;
        }
    }

    public static boolean CompareResultContains(String actual, String expected){

        if(actual.contains(expected)){
            InOutLibrary.writeLine(String.format("PASS: Actual(%s) | ExpectedToContain(%s)", actual, expected));
            return true;
        }
        else{
            InOutLibrary.writeLine(String.format("FAIL: Actual(%s) | ExpectedToContain(%s)", actual, expected));
            return false;
        }
    }


}
