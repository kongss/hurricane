package com.hurricane.coupon.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
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

    public MessengerVo getSellerRecomList(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-getSellerRecomList-param "+messenger);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("limitStart",Integer.parseInt(messenger.getString("limitStart")));
            map.put("limitSize",Integer.parseInt(messenger.getString("limitSize")));
            List<Map<String, Object>> list = sellerMapper.getSellerRecomList(map);
            messenger.clear();
            messenger.setInfo("list",list);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("SellerServiceImpl-getSellerRecomList-error "+e);
            return messenger;
        }
        logger.info("SellerServiceImpl-getSellerRecomList-result "+messenger);
        return messenger;
    }

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-getSellerInfo-param "+messenger);
            String uuid = messenger.getString("uuid");
            Seller seller = sellerMapper.selectByPrimaryKey(uuid);
            messenger.clear();
            messenger.setInfo("seller",seller);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("SellerServiceImpl-getSellerInfo-error "+e);
            return messenger;
        }
        logger.info("SellerServiceImpl-getSellerInfo-result "+messenger);
        return messenger;
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-getSellerList-param "+messenger);
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
            logger.error("SellerServiceImpl-getSellerList-error "+e);
            return messenger;
        }
        logger.info("SellerServiceImpl-getSellerList-result "+messenger);
        return messenger;
    }

    public MessengerVo getSellerSortList(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-getSellerSortList-param "+messenger);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("limitStart",Integer.parseInt(messenger.getString("limitStart")));
            map.put("limitSize",Integer.parseInt(messenger.getString("limitSize")));
            map.put("sellerTypeUuid",Integer.parseInt(messenger.getString("sellerTypeUuid")));
            List<Map<String, Object>> list = sellerMapper.getSellerSortList(map);
            messenger.clear();
            messenger.setInfo("list",list);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.info("SellerServiceImpl-getSellerSortList-error "+e);
            return messenger;
        }
        logger.info("SellerServiceImpl-getSellerSortList-result "+messenger);
        return messenger;
    }

    public MessengerVo saveSeller(MessengerVo messenger) {
        
        return messenger;
    }

    public MessengerVo saveSellerBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editSeller(MessengerVo messenger) {
        try {
            logger.info("SellerServiceImpl-editSeller-param "+messenger);
            Seller seller = new Seller();
            seller.setName(messenger.getString("name"));
            seller.setLogoPicUrl(messenger.getString("logoPicUrl"));
            seller.setSiteUrl(messenger.getString("siteUrl"));
            seller.setSource(messenger.getString("source"));
            seller.setStatus(messenger.getString("status"));
            seller.setShortUrl(messenger.getString("shortUrl"));
            seller.setLongUrl(messenger.getString("longUrl"));
            seller.setCreateTime(new Date());

            String uuid = messenger.getString("uuid");
            logger.info((uuid == null || uuid.length() == 0) ? "Execute Insert Begin" : "Execute Update Begin");
            if(StringUtils.isEmpty(messenger.getString("uuid"))){
                seller.setUuid(HuUUID.getUuid());
                sellerMapper.insertSelective(seller);
                messenger.clear();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("Insert Success");
            }else {
                seller.setUuid(uuid);
                sellerMapper.updateByPrimaryKeySelective(seller);
                messenger.clear();
                messenger.setResCode(HConstants.SUCCESS);
                messenger.setResDesc("Update Success");
            }
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Save Or Update Seller Error");
            logger.error("SellerServiceImpl-editSeller-error "+e);
            return messenger;
        }
        logger.info("SellerServiceImpl-editSeller-result "+messenger);
        return messenger;
    }

    public MessengerVo deleteSeller(MessengerVo messenger) {
        try {
            logger.error("SellerServiceImpl-deleteSeller-param "+messenger);
            String uuid = messenger.getString("uuid");
            sellerMapper.deleteByPrimaryKey(uuid);
            messenger.clear();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Delete Success");
        } catch (Exception e) {
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Delete Error");
            logger.error("SellerServiceImpl-deleteSeller-error "+e);
            return messenger;
        }
        logger.error("SellerServiceImpl-deleteSeller-result "+messenger);
        return messenger;
    }
}
