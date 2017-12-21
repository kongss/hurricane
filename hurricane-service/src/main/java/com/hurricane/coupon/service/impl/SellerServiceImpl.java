package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.SellerMapper;
import com.hurricane.coupon.entity.Seller;
import com.hurricane.coupon.service.SellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import com.hurricane.coupon.utils.page.Pager;
import com.hurricane.coupon.utils.utils.HuUUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    Logger logger = LogManager.getLogger(SellerServiceImpl.class);

    @Autowired
    SellerMapper sellerMapper;

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-getSellerInfo-参数："+messenger);
            String uuid = messenger.getString("uuid");
            Seller seller = sellerMapper.selectByPrimaryKey(uuid);
            messenger = new MessengerVo();
            messenger.setInfo("seller",seller);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("查询商城信息成功");
        } catch (Exception e) {
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("查询商城信息异常");
            logger.error("SellerServiceImpl-getSellerInfo-异常："+e);
        }
        logger.info("SellerServiceImpl-getSellerInfo-结果："+messenger);
        return messenger;
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        logger.info("SellerServiceImpl-getSellerList-入参："+messenger);
        try {
            int currentPage = Integer.parseInt(messenger.getString("currentPage"));//当前页
            int pageSize = Integer.parseInt(messenger.getString("pageSize"));//每页条数

            HashMap<String, Object> map = new HashMap<String, Object>();
            //查询总条数
            int total = sellerMapper.selectSellerTotal(map);
            //构造方法计算分页参数
            Pager pager = new Pager(currentPage, pageSize, total);

            map.put("limitStart",(currentPage-1) * pageSize);
            map.put("limitSize",pageSize);
            List<Map<String, Object>> list = sellerMapper.selectSellerList(map);
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
            messenger.setResDesc("查询商城列表成功");
        }catch (Exception e){
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("查询商城列表异常");
            logger.error("SellerServiceImpl-getSellerList-异常",e);
        }
        logger.info("SellerServiceImpl-getSellerList-出参："+messenger);
        return messenger;
    }

    public MessengerVo saveSeller(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-saveSeller-入参："+messenger);
            String name = messenger.getString("name");
            String longUrl = messenger.getString("longUrl");
            String logoPicUrl = messenger.getString("logoPicUrl");
            String siteUrl = messenger.getString("siteUrl");
            String source = messenger.getString("source");
            String status = messenger.getString("status");
            String shortUrl = messenger.getString("shortUrl");
            Seller seller = new Seller();
            seller.setUuid(HuUUID.getUuid());
            seller.setName(name);
            seller.setLongUrl(longUrl);
            seller.setLogoPicUrl(logoPicUrl);
            seller.setSiteUrl(siteUrl);
            seller.setSource(source);
            seller.setStatus(status);
            seller.setShortUrl(shortUrl);
            seller.setCreateTime(new Date());
            sellerMapper.insertSelective(seller);
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("添加商城信息成功");
        } catch (Exception e) {
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("添加商城信息失败");
            logger.error("SellerServiceImpl-saveSeller-异常",e);
        }
        logger.info("SellerServiceImpl-saveSeller-出参："+messenger);
        return messenger;
    }

    public MessengerVo saveSellerBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editSeller(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-editSeller-入参："+messenger);
            String uuid = messenger.getString("uuid");
            String name = messenger.getString("name");
            String longUrl = messenger.getString("longUrl");
            String logoPicUrl = messenger.getString("logoPicUrl");
            String siteUrl = messenger.getString("siteUrl");
            String source = messenger.getString("source");
            String status = messenger.getString("status");
            String shortUrl = messenger.getString("shortUrl");
            Seller seller = new Seller();
            seller.setUuid(uuid);
            seller.setName(name);
            seller.setLongUrl(longUrl);
            seller.setLogoPicUrl(logoPicUrl);
            seller.setSiteUrl(siteUrl);
            seller.setSource(source);
            seller.setStatus(status);
            seller.setShortUrl(shortUrl);
            sellerMapper.updateByPrimaryKey(seller);
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("修改商城信息成功");
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("修改商城信息异常");
            logger.error("SellerServiceImpl-editSeller-异常",e);
        }
        logger.info("SellerServiceImpl-editSeller-出参："+messenger);
        return messenger;
    }

    public MessengerVo deleteSeller(MessengerVo messenger) {
        try {
            logger.error("SellerServiceImpl-deleteSeller-参数",messenger);
            String uuid = messenger.getString("uuid");
            sellerMapper.deleteByPrimaryKey(uuid);
            sellerMapper.deleteByPrimaryKey(uuid);
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("删除商城信息成功");
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("删除商城信息异常");
            logger.error("SellerServiceImpl-deleteSeller-异常",e);
        }
        logger.error("SellerServiceImpl-deleteSeller-结果",messenger);
        return messenger;
    }
}
