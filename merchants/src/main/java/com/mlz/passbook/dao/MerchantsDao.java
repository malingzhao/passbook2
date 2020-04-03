package com.mlz.passbook.dao;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：
 */


import com.mlz.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantsDao extends JpaRepository<Merchants, Integer> {


    /**
     * <h2>根据id获取商户对象</h2>
     *
     * @param id * @param id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);


    /**
     * <h2>根据商户名称获取商户对象</h2>
     *
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);

}
