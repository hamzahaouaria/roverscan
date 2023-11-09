package com.hhaouari.roverscan.utils;

import com.hhaouari.roverscan.constants.TestResources;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalOutputUtilTest {

  TerminalOutputUtil terminalOutputUtil;

  @BeforeEach
  void setUp() {
    terminalOutputUtil = new TerminalOutputUtil();
  }

  @BeforeEach
  void tearDown() {
    terminalOutputUtil = null;
  }


  @Test
  void testFinalTerminalOutputWithArgs() {
    String[] args = { TestResources.SAMPLE_TEST_CASE_BASIC };
    String output = terminalOutputUtil.finalTerminalOutput(args);
    String expectedOutput = "1 3 N\n5 1 E";
    assertEquals(expectedOutput, output);
  }

  @Test
    void testFinalTerminalOutputWithNoArgs() {
        String[] args = {};
        String output = terminalOutputUtil.finalTerminalOutput(args);
        String expectedOutput = "";
        assertEquals(expectedOutput, output);
    }

    @Test
    void testFinalTerminalOutputWithMoreThenOneArgs() {
        String[] args = { TestResources.SAMPLE_TEST_CASE_BASIC, TestResources.SAMPLE_TEST_CASE_CUSTOM };
        String output = terminalOutputUtil.finalTerminalOutput(args);
        String expectedOutput = "";
        assertEquals(expectedOutput, output);
    }

    @Test
    void testFinalTerminalOutputWithNotExistsArgs() {
        String[] args = { TestResources.SRC_TEST_RESOURCES_NOEXIST_TXT };
        String output = terminalOutputUtil.finalTerminalOutput(args);
        String expectedOutput = "";
        assertEquals(expectedOutput, output);
    }


  @Test
  void testValidateArgsValid() {
    String[] args = { TestResources.SAMPLE_TEST_CASE_BASIC };
    boolean isValid = terminalOutputUtil.validateArgs(args);
    assertTrue(isValid);
  }

  @Test
  void testValidateArgsNotExists() {
    String[] args = { TestResources.SRC_TEST_RESOURCES_NOEXIST_TXT };
    boolean isValid = terminalOutputUtil.validateArgs(args);
    assertFalse(isValid);
  }

  @Test
  void testValidateArgsMoreThenOne() {
    String[] args = { TestResources.SAMPLE_TEST_CASE_BASIC, TestResources.SAMPLE_TEST_CASE_CUSTOM };
    boolean isValid = terminalOutputUtil.validateArgs(args);
    assertFalse(isValid);
  }

  @Test
  void testValidateArgsEmpty() {
    String[] args = {};
    boolean isValid = terminalOutputUtil.validateArgs(args);
    assertFalse(isValid);
  }
}