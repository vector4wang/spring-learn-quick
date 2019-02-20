package com.spring.learning.test.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vector
 * @date: 2019/2/20 0020 10:11
 */
public abstract class AbstractTestFactory implements TestFactory {

    private Map<String, String> testMaps = new HashMap<String, String>();

    public Object getTest(String name) {
        return testMaps.get(name);
    }


    public void regesiterTestBean(String name, String value) {
        String test = doFillTest(value);
        testMaps.put(name, test);
    }

    protected abstract String doFillTest(String value);
}
