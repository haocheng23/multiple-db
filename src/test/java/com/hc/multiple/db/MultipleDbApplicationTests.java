package com.hc.multiple.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDbApplicationTests {

    @Resource
    private com.hc.multiple.db.controller.testController testController;

    @Test
    public void getDept() {
        testController.getDept();
    }

    @Test
    public void getDept1() {
        testController.getDept1();
    }

    @Test
    public void getDept2() {
        testController.getDept2();
    }

}
