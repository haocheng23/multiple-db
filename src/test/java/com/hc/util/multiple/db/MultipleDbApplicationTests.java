package com.hc.util.multiple.db;

import com.hc.util.multiple.db.controller.testController;
import com.hc.util.multiple.db.model.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDbApplicationTests {

    @Resource
    private testController testController;

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
