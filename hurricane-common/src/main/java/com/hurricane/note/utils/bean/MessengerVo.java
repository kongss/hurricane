package com.hurricane.note.utils.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MessengerVo implements Serializable{

    /** 业务参数集合 */
    private Map<String, Object> map =  new HashMap<String, Object>();
    /** 响应码 */
    private String resCode;
    /** 描述信息 */
    private String resDesc;
    /** 客户端IP */
    private String clientIp;

    /** 获取map对象 */
    public String getString(String key){
        Object obj = map.get(key);
        if (obj != null){
            if (obj.getClass().getSimpleName().equals("BigDecimal")){
                return ((BigDecimal)obj).toPlainString();
            }
        }
        return String.valueOf(obj);
    }

    /** put业务参数 */
    public void setInfo(String key, Object value) {
        map.put(key, value);
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
