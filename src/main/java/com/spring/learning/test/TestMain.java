package com.spring.learning.test;

import com.spring.learning.test.context.TestContext;

/**
 * @author vector
 * @date: 2019/2/20 0020 10:51
 */
public class TestMain {
    public static void main(String[] args) {
        TestContext testContext = new TestContext("1<==>2");
        Object test = testContext.getTest("1");
        System.out.println(test);
    }
}
