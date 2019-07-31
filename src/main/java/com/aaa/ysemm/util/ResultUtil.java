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
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResultUtil {
    private int code;
    private String msg;
    private Map<String,Object> map;
}
