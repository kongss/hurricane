package com.hurricane.coupon.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hurricane.coupon.dao.CouponInfoMapper;
import com.hurricane.coupon.dao.CouponMapper;
import com.hurricane.coupon.entity.Coupon;
import com.hurricane.coupon.entity.CouponInfo;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import com.hurricane.coupon.utils.page.Pager;
import com.hurricane.coupon.utils.utils.HuUUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CouponServiceImpl implements CouponService{

    Logger logger = LogManager.getLogger(CouponServiceImpl.class);

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouponInfoMapper couponInfoMapper;

    public MessengerVo getCoupon(MessengerVo messenger) {
        String uuid = messenger.getString("uuid");
        Coupon coupon = couponMapper.selectByPrimaryKey(uuid);
        messenger = new MessengerVo();
        messenger.setInfo("coupon",coupon);
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setResDesc("查询成功");
        return messenger;
    }

    public MessengerVo getCouponInfoList(MessengerVo messenger) {
        try {
            HashMap<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> list = couponInfoMapper.selectCouponInfoList(map);
            messenger = new MessengerVo();
            messenger.setInfo("list",list);
            messenger.setResDesc("查询成功");
            messenger.setResCode(HConstants.SUCCESS);
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResDesc("查询失败");
            messenger.setResCode(HConstants.ERROR);
            logger.error("getCouponInfoList-异常",e);
        }
        return messenger;
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        logger.info("CouponServiceImpl-getCouponList-参数："+messenger);
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
        return messenger;
    }

    public MessengerVo saveCouponBatch(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-saveCouponBatch-参数"+messenger);
            ArrayList<CouponInfo> list = new ArrayList<CouponInfo>();
            CouponInfo info;
            String jsonArray = messenger.getString("jsonArray");
            String couponUuid = messenger.getString("couponUuid");
            JSONArray array = JSONArray.parseArray(jsonArray);
            System.out.println("总数量："+array.size());
            for(int i = 0; i < array.size(); i++){
                info = new CouponInfo();
                JSONObject object = JSON.parseObject(String.valueOf(array.get(i)));
                String number = object.getString("number");
                String code = object.getString("code");
                System.out.println("number:"+number+"  code:"+code);
                info.setUuid(HuUUID.getUuid());
                info.setNumber(number);
                info.setCode(code);
                info.setStatus("1");
                info.setCouponUuid(couponUuid);
                list.add(info);
            }
            int i = couponInfoMapper.insertCouponBatch(list);
            logger.info("插入条数"+i);
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("批量插入成功");
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("批量插入异常");
            logger.error("批量插入异常",e);
        }
        logger.info("CouponServiceImpl-saveCouponBatch-结果"+messenger);
        return messenger;
    }

    public MessengerVo editCoupon(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-editCoupon-参数："+messenger);
            Coupon coupon = new Coupon();
            coupon.setName(messenger.getString("name"));
            coupon.setDerateAmount(messenger.getString("derateAmount"));
            coupon.setStartTime(messenger.getString("startTime"));
            coupon.setEndTime(messenger.getString("endTime"));
            coupon.setUseExplain(messenger.getString("useExplain"));
            coupon.setActivityLinkUrl(messenger.getString("activityLinkUrl"));
            coupon.setType(messenger.getString("type"));
            coupon.setStatus(messenger.getString("status"));
            coupon.setIsRecom(messenger.getString("isRecom"));
            coupon.setSellerUuid(messenger.getString("sellerUuid"));
            if (StringUtils.isEmpty(messenger.getString("uuid"))){//添加操作
                coupon.setUuid(HuUUID.getUuid());
                coupon.setCreateTime(new Date());
                couponMapper.insertSelective(coupon);
                messenger = new MessengerVo();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("添加优惠券信息成功");
            }else {//修改操作
                coupon.setUuid(messenger.getString("uuid"));
                couponMapper.updateByPrimaryKeySelective(coupon);
                messenger = new MessengerVo();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("修改优惠券信息成功");
            }
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("添加/修改优惠券信息异常");
            logger.info("CouponServiceImpl-editCoupon-异常：",e);
        }
        logger.info("CouponServiceImpl-editCoupon-结果："+messenger);
        return messenger;
    }

    public MessengerVo deleteCoupon(MessengerVo messenger) {
        return null;
    }
}
