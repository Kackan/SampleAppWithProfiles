package com.kackan.zad_dom_tydz2.service;

import com.kackan.zad_dom_tydz2.entity.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;


public class ShopBasic implements Shop{

    private List<Product> products;
    private double sum;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void fillShop()
    {
        products=new ArrayList<>();
        products.add(new Product("Books", getRandomPrice()));
        products.add(new Product("SeaFood",getRandomPrice()));
        products.add(new Product("Vegetables",getRandomPrice()));
        products.add(new Product("Fruits",getRandomPrice()));
        products.add(new Product("Newspapers",getRandomPrice()));
        toPay(products);
    }

    public void toPay(List<Product>products)
    {
        products.
                stream()
                .forEach(p->{
                    sum+=p.getPrice();
                    System.out.println(p.getName()+", price: "+String.format("%.2f",p.getPrice())+" zł");
                });

        System.out.println(String.format("%.2f",sum));
    }

    @Override
    public double getRandomPrice()
    {
        double min=50;
        double max=300;
        double price=(Math.random() *((max-min)+1))+min;
        return price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}