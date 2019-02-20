package com.spring.learning.test.context;

import com.spring.learning.test.factory.AbstractTestFactory;
import com.spring.learning.test.factory.AutowireTestFactory;
import com.spring.learning.test.factory.TestFactory;

/**
 * @author vector
 * @date: 2019/2/20 0020 10:45
 */
public class TestContext implements TestFactory {

    private String location;

    protected AbstractTestFactory abstractTestFactory;

    public TestContext(String location) {
        this(new AutowireTestFactory());
        this.location = location;
        refresh();
    }

    private void refresh() {
        String[] split = this.location.split("<==>");
        abstractTestFactory.regesiterTestBean(split[0],split[1]);
    }

    public TestContext(AbstractTestFactory abstractTestFactory) {
        this.abstractTestFactory = abstractTestFactory;
    }

    public Object getTest(String name) {
        return abstractTestFactory.getTest(name);
    }
}
