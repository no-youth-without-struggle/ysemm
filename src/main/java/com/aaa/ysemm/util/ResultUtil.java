package com.aaa.ysemm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.util
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 15:25
 * @Version: 1.0
 */
/*@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString*/
public class ResultUtil {
    private int code;
    private String msg;
    private Map<String,Object> map;

    public ResultUtil(int code, String msg, Map<String, Object> map) {
        this.code = code;
        this.msg = msg;
        this.map = map;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
