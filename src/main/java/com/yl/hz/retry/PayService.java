package com.yl.hz.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Slf4j
@Service
public class PayService {

    private static int totalNum = 1000;

    @MyRetry
    public int minGoodsnum(int num){
        log.info("减库存开始" + LocalTime.now());
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("illegal");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束" + LocalTime.now());
        return totalNum - num;
    }

}
