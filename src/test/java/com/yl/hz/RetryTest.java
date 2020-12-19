package com.yl.hz;

import com.yl.hz.retry.PayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RetryTest {

    @Autowired
    private PayService payService;

    @Test
    public void MyRetryTest() {
        try {
            payService.minGoodsnum(-1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SpringRetryTest() {

    }

}
