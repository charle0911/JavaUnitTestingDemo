package com.demo.teach.junit4.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
       TestOne.class,
       TestTwo.class
})
public class TestSuite {
}
