package com.mlz.passbook.vo;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>创建商户响应对象</h2>
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponse {
    /*商户id : 创建失败 则为-1 */
    private Integer id;

}
