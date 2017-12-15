package com.hurricane.coupon.service.impl;

import com.alibaba.fastjson.JSON;
import com.hurricane.coupon.dao.CouponMapper;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import com.hurricane.coupon.utils.page.Pager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImpl implements CouponService{

    Logger logger = LogManager.getLogger(CouponServiceImpl.class);

    @Autowired
    CouponMapper couponMapper;

    public MessengerVo getCouponInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        logger.info("CouponServiceImpl-getCouponList-入参："+messenger);
        try {
            int currentPage = Integer.parseInt(messenger.getString("currentPage"));//当前页
            int pageSize = Integer.parseInt(messenger.getString("pageSize"));//每页条数

            HashMap<String, Object> map = new HashMap<String, Object>();
            int total = couponMapper.selectCouponTotal(map);
            Pager pager = new Pager(currentPage, pageSize, total);

            map.put("limitStart",(currentPage-1) * pageSize);
            map.put("limitSize",pageSize);
            List<Map<String, Object>> list = couponMapper.selectCouponList(map);
            logger.info("CouponServiceImpl-查询结果",list);
            messenger = new MessengerVo();
            messenger.setInfo("list",list);
            messenger.setInfo("pageTotal",pager.getPageTotal());
            messenger.setInfo("currentPage",pager.getCurrentPage());
            messenger.setInfo("firstPage",pager.getFirstPage());
            messenger.setInfo("lastPage",pager.getLastPage());
            messenger.setInfo("nextPage",pager.getNextPage());
            messenger.setInfo("pageSize",pager.getPageSize());
            messenger.setInfo("previousPage",pager.getPreviousPage());
            messenger.setInfo("recordTotal",pager.getRecordTotal());
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("查询优惠券列表成功");
        }catch (Exception e){
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("查询优惠券列表异常");
            logger.error("CouponServiceImpl-getCouponList-异常",e);
        }
        logger.info("CouponServiceImpl-getCouponList-出参："+messenger);
        return messenger;
    }

    public MessengerVo saveCoupon(MessengerVo messenger) {
        return null;
    }

    public MessengerVo saveCouponBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editCoupon(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteCoupon(MessengerVo messenger) {
        return null;
    }
}
