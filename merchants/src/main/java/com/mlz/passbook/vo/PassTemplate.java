package com.mlz.passbook.vo;


/*<>
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */


import com.mlz.passbook.constant.ErrorCode;
import com.mlz.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <h1>投放的优惠券对象定义</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    /*所属商户id*/
    private Integer id;
    /*优惠券标题*/
    private String title;
    /*优惠券摘要*/
    private String summayy;
    /*优惠券详细信息*/
    private String desc;
    /*最大个数限制*/
    private Long limit;


    /*优惠券s是否有token*/
    private Boolean hasToken; //token 存储与Redis Set中每次领取在Redis中领取

    /*优惠券背景色*/
    private Integer background;
    /*优惠券开始时间*/
    private Date start;
    /*优惠券结束时间*/
    private Date end;

    /**
     * <h2>校验优惠券对象的有效性</h2>
     *
     * @param merchantsDao
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (null == merchantsDao.findById(id)) {
            return ErrorCode.MERCHANTS_NOT_EXISTS;
        }
        return ErrorCode.SUCCESS;
    }
}
