package com.oms.utils;

import cn.hutool.core.util.ArrayUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookieUtils {

    public static String get(HttpServletRequest request,String key){
        Map<String, String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(ArrayUtil.isEmpty(cookies)){
            return null;
        }else {
            for (Cookie cookie : cookies) {
                map.put(cookie.getName(),cookie.getValue());
            }
            return map.get(key);
        }
    }

    public static void set(HttpServletResponse response,Map<String, String> map){
        map.forEach((key,value) -> response.addCookie(new Cookie(key,value)));
    }
}
