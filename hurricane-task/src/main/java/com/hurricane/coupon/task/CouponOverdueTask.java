package com.hurricane.coupon.task;


import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class CouponOverdueTask {

    @Autowired
    DCouponService dCouponService;

    //@Scheduled(cron = "0 */1 *  * * * ")
    @Scheduled(cron = "0 0 1,2 * * ? ")
    public void checkCouponOverdue(){//每天凌晨1点 2点执行
        System.out.println("Task Start");
        MessengerVo messenger = new MessengerVo();
        messenger = dCouponService.updateOverdueCoupon(messenger);
        System.out.println(messenger);
        System.out.println("Task End");
    }

}
