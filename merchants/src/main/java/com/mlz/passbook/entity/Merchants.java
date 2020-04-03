package com.mlz.passbook.entity;


/*
 * @创建人: MaLingZhao
 * @创建时间: 2020/2/26
 * @描述：<h1>商户对象模型</h1>
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.TransactionScoped;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {



    /*用户id  主键*/
    @Id
    @GeneratedValue //自增的主键
    @Column(name = "id", nullable = false)
    private Integer id;
    /*商户名称 需要全局唯一的*/
    @Basic//基本列
    @TransactionScoped
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /*商户营业执照*/
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;


    /*商户的联系电话*/
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /*商户地址*/
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    /*商户是否通过审核的一个标志位*/
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;

}
