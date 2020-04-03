package com.mlz.passbook.service.impl;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */

import com.alibaba.fastjson.JSON;
import com.mlz.passbook.constant.Constants;
import com.mlz.passbook.constant.ErrorCode;
import com.mlz.passbook.dao.MerchantsDao;
import com.mlz.passbook.entity.Merchants;
import com.mlz.passbook.service.IMerchantsServ;
import com.mlz.passbook.vo.CreateMerchantsRequest;
import com.mlz.passbook.vo.CreateMerchantsResponse;
import com.mlz.passbook.vo.PassTemplate;
import com.mlz.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <h1>商户服务接口实现</h1>
 */
@Slf4j
@Service
public class MerchantsServImpl implements IMerchantsServ {


    /*Merchantss数据库接口*/
    @Autowired
    private MerchantsDao merchantsDao;

    /*kafka客户端*/
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao,
                             KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }/**/


    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != errorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }
        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMErchantsInfoById(Integer id) {
        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);
        if (null == merchants) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXISTS.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXISTS.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            String passTemplate = JSON.toJSONString(template);
            // K V
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );
            log.info("DropPassTemplate:{}", passTemplate);
        }
        return response;
    }
}
