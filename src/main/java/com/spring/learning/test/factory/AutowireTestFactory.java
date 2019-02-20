package com.spring.learning.test.factory;

import java.util.Random;

/**
 * @author vector
 * @date: 2019/2/20 0020 10:18
 */
public class AutowireTestFactory extends AbstractTestFactory {

    protected String doFillTest(String value) {
        return "假装[" + value + "]处理一下";
    }
}
