package com.mlz.passbook.service;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */

import com.mlz.passbook.vo.CreateMerchantsRequest;
import com.mlz.passbook.vo.PassTemplate;
import com.mlz.passbook.vo.Response;

/**
 * <h1>商户服务的接口定义</h1>
 */

public interface IMerchantsServ {
    /**
     * <h2> 创建商户服务</h2>
     *
     * @param request 创建商户请求 {@link CreateMerchantsRequest}
     * @return request {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据id构造商户信息</h2>
     *
     * @param id 商户id
     * @return {@link Response}
     */
    Response buildMErchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     *
     * @param template {@link PassTemplate}
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
