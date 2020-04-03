package com.mlz.passbook.service;

import com.alibaba.fastjson.JSON;
import com.mlz.passbook.vo.CreateMerchantsRequest;
import com.mlz.passbook.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;



/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */

/**
 * <h1>商户服务测试类</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class IMerchantsServTest {

    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
//    @Transactional
    public void testCreateMerchantsServ() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("1234567890");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }


    /*{"data":{"address":"北京市","businessLicenseUrl":"www.imooc.com","id":18,
    "isAudit":false,"logoUrl":"www.imooc.com","name":"慕课","phone":"1234567890"}}*/
    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(merchantsServ.buildMErchantsInfoById(18)));
    }



    /*bin/kaf
    * */
    /* ropPassTemplate:{"background":2,"desc":"详情：慕课",
    "end":1583573863998,"hasToken":false,"id":18,"limit":10000,"start":1582709863998,
    "summayy":"简介:慕课","title":"title:慕课"}*/
    @Test
    public void testDropPassTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(18);
        passTemplate.setTitle("title:慕课");
        passTemplate.setSummayy("简介:慕课");
        passTemplate.setDesc("详情：慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));
        System.out.println(JSON.toJSONString(merchantsServ.dropPassTemplate(passTemplate)));
    }
}