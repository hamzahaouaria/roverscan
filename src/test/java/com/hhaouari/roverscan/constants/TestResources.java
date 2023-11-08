package com.hhaouari.roverscan.constants;

import java.util.HashMap;
import java.util.Map;

public class TestResources {

    private static Map<String,String> testFilesMessages;

    public static final String SAMPLE_TEST_CASE_BASIC = "src/test/resources/input-case-1.txt";
    public static final String SRC_TEST_RESOURCES_NOEXIST_TXT = "src/test/resources/noexist.txt";

    public static final String NOT_VALID_PLATEAU_SIZE = "src/test/resources/input-case-not-valid-1.txt";
    public static final String NOT_VALID_ROVER_POSITION = "src/test/resources/input-case-not-valid-2.txt";


    public static Map<String,String>  testFilesMessage(){
        if(testFilesMessages != null)
            return testFilesMessages;

        testFilesMessages = new HashMap<>();
        testFilesMessages.put(SAMPLE_TEST_CASE_BASIC,"Test if a valid mission file is valid");
        testFilesMessages.put(SRC_TEST_RESOURCES_NOEXIST_TXT,"Test if an invalid mission file is invalid for not found.");
        testFilesMessages.put(NOT_VALID_PLATEAU_SIZE,"Test if an invalid mission file is invalid for wrong format plateau size.");
        testFilesMessages.put(NOT_VALID_ROVER_POSITION,"Test if an invalid mission file is invalid for wrong format rover position.");
        return testFilesMessages;

    }
}
