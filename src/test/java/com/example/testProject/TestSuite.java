package com.example.testProject;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ArraysCompareTest.class, BeforeAfterTest.class, StringHelperParameterTest.class, StringHelperTest.class})
public class TestSuite {

}