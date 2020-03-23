package com.kackan.zad_dom_tydz2.service;

import com.kackan.zad_dom_tydz2.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("pro")
public class ShopPro extends ShopPlus{

    @Value("${discount}")
    private double discount;


    @Override
    public void toPay(List<Product> products) {
        super.toPay(products);
        System.out.println("To pay with discount: "+String.format("%.2f",(getSum()*discount)));
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}