package com.hurricane.coupon.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;

@Controller
@RequestMapping("/admin/coupon")
public class CouponController {

    @Autowired
    DCouponService dCouponService;

    @RequestMapping("/couponList")
    @ResponseBody
    MessengerVo couponList(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");//当前页
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        String pageSize = request.getParameter("pageSize");//每页条数
        if (StringUtils.isEmpty(pageSize)){
            pageSize = "10";
        }
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("currentPage", currentPage);
        messenger.setInfo("pageSize",pageSize);

        System.out.println("CouponController-前"+messenger);
        messenger = dCouponService.getCouponList(messenger);
        System.out.println("CouponController-后"+messenger);
        return messenger;
    }

    @RequestMapping("/getCoupon")
    @ResponseBody
    MessengerVo getCoupon(HttpServletRequest request,String uuid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("uuid",uuid);
        System.out.println("CouponController-getCoupon-参数："+messenger);
        messenger = dCouponService.getCouponInfo(messenger);
        System.out.println("CouponController-getCoupon-结果："+messenger);
        return messenger;
    }

    @RequestMapping("/editCoupon")
    @ResponseBody
    MessengerVo editCoupon(String uuid, String name, String derateAmount, String startTime, String endTime,
                           String useExplain, String activityLinkUrl, String type, String status, String isRecom, String sellerUuid){

        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("uuid",uuid);
        messenger.setInfo("name",name);
        messenger.setInfo("derateAmount",derateAmount);
        messenger.setInfo("startTime",startTime);
        messenger.setInfo("endTime",endTime);
        messenger.setInfo("useExplain",useExplain);
        messenger.setInfo("activityLinkUrl",activityLinkUrl);
        messenger.setInfo("type",type);
        messenger.setInfo("status",status);
        messenger.setInfo("isRecom",isRecom);
        messenger.setInfo("sellerUuid",sellerUuid);
        messenger = dCouponService.editCoupon(messenger);
        return messenger;
    }

    @RequestMapping("/analysisExcel")
    @ResponseBody MessengerVo toInExcel(@RequestParam("file") MultipartFile file,String flag) throws Exception {
        MessengerVo messenger = new MessengerVo();
        //String filepath = "D:/cData07.xlsx";
        InputStream is = file.getInputStream();
        String fileName = file.getOriginalFilename();
        //InputStream is = new FileInputStream(filepath);
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("suffix = " + suffix);
        Workbook wbc = WorkbookFactory.create(is);
        Sheet sheet = wbc.getSheetAt(1);
        int rowNum = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("rowNum:" + rowNum + "   colNum:" + colNum);
        //从1开始，跳过表头的标题
        //Map<Object, Object> m = new LinkedHashMap<>();
        //List<Object> list = new ArrayList<>();
        if ("show".equals(flag)) {//预览
            System.out.println(".................预览操作.................");
            int t = 1;
            String cv = "";
            for (int i = 1; i <= rowNum; i++) {
                row = sheet.getRow(i);
                cv += "[" + t + "] ";
                t++;
                for (int j = 0; j < colNum; j++) {
                    Object obj = getCellFormatValue(row.getCell(j));
                    //System.out.println("obj[" + i + "*" + j + "]======================" + obj);
                    cv += "[" + obj + "] ";
                }
                cv += "\n";
                messenger.setInfo("cv", cv);
            }
        } else {//入库
            System.out.println(".................入库操作.................");
            //List<Object> list = new ArrayList<>();
            //HashSet<Object> hashSet;
            JSONObject object;
            JSONArray jsonArray = new JSONArray();
            for (int i = 1; i <= rowNum; i++) {
                object = new JSONObject();
                row = sheet.getRow(i);
                Object number = getCellFormatValue(row.getCell(0));
                Object code = getCellFormatValue(row.getCell(1));
                object.put("number",number);
                object.put("code",code);
                jsonArray.add(object);
            }
            System.out.println("jsonArray： "+jsonArray);

            messenger.setInfo("jsonArray",jsonArray);
            messenger.setInfo("sellerUuid","111111111111111");
            messenger = dCouponService.saveCouponBatch(messenger);
        }

        return messenger;
    }

    @RequestMapping("/deleteCoupon")
    @ResponseBody
    MessengerVo deleteCoupon(){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }
    private static Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            /*
            _NONE(-1),
            NUMERIC(0),
            STRING(1),
            FORMULA(2),
            BLANK(3),
            BOOLEAN(4),
            ERROR(5);
            */
            switch (cell.getCellTypeEnum()) {
                case _NONE: {
                    cellvalue = "_NONE";
                    break;
                }
                case NUMERIC: {
                    cellvalue = cell.getNumericCellValue();
                    break;
                }
                case STRING: {
                    cellvalue = cell.getStringCellValue();
                    break;
                }
                case FORMULA: {
                    cellvalue = cell.getCellFormula();
                    break;
                }
                case BLANK: {
                    cellvalue = "";
                    break;
                }
                case BOOLEAN: {
                    cellvalue = cell.getBooleanCellValue();
                    break;
                }
                case ERROR: {
                    cellvalue = cell.getErrorCellValue();
                    break;
                }
                default: {
                    cellvalue = "";
                    break;
                }
            }
        }
        return cellvalue;
    }
}
