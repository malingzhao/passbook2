package com.mlz.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.mlz.passbook.service.IMerchantsServ;
import com.mlz.passbook.vo.CreateMerchantsRequest;
import com.mlz.passbook.vo.PassTemplate;
import com.mlz.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>商户服务controller</h1>
 *
 * @author Malingzhao
 * @date 2020-03-26 11:33
 */

@RestController
@Slf4j
@RequestMapping("/merchants")
public class MerchantsController {


    //商户服务接口
    private final IMerchantsServ merchantsServ;


    @Autowired
    public MerchantsController(IMerchantsServ merchantsServ) {
        this.merchantsServ = merchantsServ;
    }

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }


    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable("id") Integer id) {
        log.info("BuildMerchantsInfo:{}", id);
        return merchantsServ.buildMErchantsInfoById(id);
    }



    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate( @RequestBody  PassTemplate passTemplate) {
        log.info("DropPassTemplate:{}", passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }
}
