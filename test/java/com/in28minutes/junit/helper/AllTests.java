package com.in28minutes.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuickBeforeAfterTest.class, StringHelperParametrizedTest.class })
public class AllTests {

}
