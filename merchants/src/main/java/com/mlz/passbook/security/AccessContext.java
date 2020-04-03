package com.mlz.passbook.security;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：<h1>用ThreadLocal单独存储每一个线程携带的token信息</h1>
 */
/*
 * spring支持高并发的请求   ThreadLocal
 * */

public class AccessContext {

    private static final ThreadLocal<String> token = new ThreadLocal<String>();

    public static String getToken() {
        return token.get();

    }

    public static void  setToken(String tokenStr) {

        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
