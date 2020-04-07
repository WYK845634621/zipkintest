package com.kingstar.zipkintest.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/7 11:07
 */
@RestController
@RequestMapping("/server1")
public class ZipkinBraveController1 {

    @Autowired
    private OkHttpClient client;

    /**
     * @Description: 第一步调用
     * @Param:
     * @return:  字符串
     * @Author: Mr.Yang
     * @Date: 2018/7/3
     */
    @RequestMapping(value = "/zipkin", method = RequestMethod.GET)
    public String service1() throws Exception {
        TimeUnit.SECONDS.sleep(3);
//        return "hello";
        Thread.sleep(100);
        Request request = new Request.Builder().url("http://localhost:9001/server2/zipkin").build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
