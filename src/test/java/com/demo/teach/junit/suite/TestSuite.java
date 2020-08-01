package com.demo.teach.junit.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       TestOne.class,
       TestTwo.class
})
public class TestSuite {
}
