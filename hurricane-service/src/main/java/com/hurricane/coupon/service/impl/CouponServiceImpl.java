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
        try {
            logger.info("CouponServiceImpl-getCoupon-param ",messenger);
            String uuid = messenger.getString("uuid");
            Coupon coupon = couponMapper.selectByPrimaryKey(uuid);
            messenger.clear();
            messenger.setInfo("coupon",coupon);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("CouponServiceImpl-getCoupon-error ",e);
        }
        logger.info("CouponServiceImpl-getCoupon-result ",messenger);
        return messenger;
    }

    public MessengerVo getCouponInfoList(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-getCouponInfoList-param ",messenger);
            HashMap<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> list = couponInfoMapper.selectCouponInfoList(map);
            messenger.clear();
            messenger.setInfo("list",list);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("CouponServiceImpl-getCouponInfoList-error ",e);
        }
        logger.info("CouponServiceImpl-getCouponInfoList-result ",messenger);
        return messenger;
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-getCouponList-param "+messenger);
            int currentPage = Integer.parseInt(messenger.getString("currentPage"));//当前页
            int pageSize = Integer.parseInt(messenger.getString("pageSize"));//每页条数

            HashMap<String, Object> map = new HashMap<String, Object>();
            int total = couponMapper.selectCouponTotal(map);
            Pager pager = new Pager(currentPage, pageSize, total);

            map.put("limitStart",(currentPage-1) * pageSize);
            map.put("limitSize",pageSize);
            logger.info("query:param{map} ",map);
            List<Map<String, Object>> list = couponMapper.selectCouponList(map);
            logger.info("query:result{list} ",list);
            messenger.clear();
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
            messenger.setResDesc("Query Success");
        }catch (Exception e){
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("CouponServiceImpl-getCouponList-error ",e);
        }
        logger.info("CouponServiceImpl-getCouponList-result "+messenger);
        return messenger;
    }

    public MessengerVo saveCoupon(MessengerVo messenger) {
        return messenger;
    }

    public MessengerVo saveCouponBatch(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-saveCouponBatch-param "+messenger);
            ArrayList<CouponInfo> list = new ArrayList<CouponInfo>();
            CouponInfo info;
            String jsonArray = messenger.getString("jsonArray");
            String couponUuid = messenger.getString("couponUuid");
            JSONArray array = JSONArray.parseArray(jsonArray);
            for(int i = 0; i < array.size(); i++){
                info = new CouponInfo();
                JSONObject object = JSON.parseObject(String.valueOf(array.get(i)));
                String number = object.getString("number");
                String code = object.getString("code");
                info.setUuid(HuUUID.getUuid());
                info.setNumber(number);
                info.setCode(code);
                info.setStatus("1");
                info.setCouponUuid(couponUuid);
                list.add(info);
            }
            logger.info("save:param{list} "+list);
            int i = couponInfoMapper.insertCouponBatch(list);
            logger.info("save:result{num} "+i);
            messenger.clear();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Save Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Save Error");
            logger.error("CouponServiceImpl-saveCouponBatch-error ",e);
        }
        logger.info("CouponServiceImpl-saveCouponBatch-result "+messenger);
        return messenger;
    }

    public MessengerVo editCoupon(MessengerVo messenger) {
        try {
            logger.info("CouponServiceImpl-editCoupon-param "+messenger);
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

            String uuid = messenger.getString("uuid");
            logger.info((uuid == null || uuid.length() == 0) ? "Execute Insert Begin" : "Execute Update Begin");
            if (StringUtils.isEmpty(messenger.getString("uuid"))){//添加操作
                coupon.setUuid(HuUUID.getUuid());
                coupon.setCreateTime(new Date());
                couponMapper.insertSelective(coupon);
                messenger.clear();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("Insert Success");
            }else {//修改操作
                coupon.setUuid(messenger.getString("uuid"));
                couponMapper.updateByPrimaryKeySelective(coupon);
                messenger.clear();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("Update Success");
            }
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Save Or Update Coupon Error");
            logger.info("CouponServiceImpl-editCoupon-error ",e);
        }
        logger.info("CouponServiceImpl-editCoupon-result "+messenger);
        return messenger;
    }

    public MessengerVo deleteCoupon(MessengerVo messenger) {
        return null;
    }
}
