package com.mlz.passbook.vo;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */

import com.mlz.passbook.constant.ErrorCode;
import com.mlz.passbook.dao.MerchantsDao;
import com.mlz.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2> 创建商户请求对象</h2>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {
    /*商户名称*/
    private String name;
    /*商户 logo*/
    private String logoUrl;

    /*商户营业执照*/
    private String businessLicenseUrl;
    /*商户联系电话*/
    private String phone;

    /*商户地址*/
    private String address;

    /**
     * <h3>验证请求的有效性</h3>
     *
     * @param merchantsDao
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (merchantsDao.findByName(this.name) != null) {
            return ErrorCode.DUPLICATE_NAME;
        }
        if (null == this.logoUrl) {
            return ErrorCode.EMPTY_LOGO;
        }
        if (null == this.businessLicenseUrl) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if (null == address) {
            return ErrorCode.EMPTY_ADDRESS;
        }
        if (null == this.phone) {
            return ErrorCode.ERROR_PHONE;
        }
        return ErrorCode.SUCCESS;
    }

    /**
     * <h2>将请求对象转换为商户对象</h2>
     *
     * @return
     * @Return {@link Merchants}
     */
    public Merchants toMerchants() {

        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        return  merchants;
    }
}
