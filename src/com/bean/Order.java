package com.bean;

import java.util.List;

/**
 * 订单信息
 */

public class Order {
    private String id;
    private float customerType;         //乘机人类型
    private float airportTax;           //机场税
    private float fuel;                 //燃油费
    private float generalInsurance;     //航空综合险
    private float modifyInsurance;      //机票退改险
    private float coupon;               //优惠券
    private List<Customer> customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getCustomerType() {
        return customerType;
    }

    public void setCustomerType(float customerType) {
        this.customerType = customerType;
    }

    public float getAirportTax() {
        return airportTax;
    }

    public void setAirportTax(float airportTax) {
        this.airportTax = airportTax;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public float getGeneralInsurance() {
        return generalInsurance;
    }

    public void setGeneralInsurance(float generalInsurance) {
        this.generalInsurance = generalInsurance;
    }

    public float getModifyInsurance() {
        return modifyInsurance;
    }

    public void setModifyInsurance(float modifyInsurance) {
        this.modifyInsurance = modifyInsurance;
    }

    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
