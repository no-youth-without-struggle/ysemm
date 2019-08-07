package com.aaa.ysemm.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.util
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 15:25
 * @Version: 1.0
 */

public class ResultUtil {
    public static final int CODE_SUCCESS=200;
    public static final int CODE_FAIL=400;
    public static final int CODE_OTHER=300;

    public static final String MSG_SUCCESS="操作成功";
    public static final String MSG_FAIL="操作失败";
    private  static  String MSG_OTHER="";



    private int code;
    private String msg;
    private Object obj;

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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResultUtil{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }

    public ResultUtil(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
}
