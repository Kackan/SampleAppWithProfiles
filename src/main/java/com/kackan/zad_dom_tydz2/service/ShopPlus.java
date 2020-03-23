package com.kackan.zad_dom_tydz2.service;

import com.kackan.zad_dom_tydz2.entity.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties(prefix = "vat")
@Profile("plus")
public class ShopPlus extends ShopBasic{

    private double bookFruitVegetable;
    private double newspaper;
    private double seaFood;

    private double sum;


    @Override
    public void toPay(List<Product> products) {

        products.
                stream()
                .forEach(p->{

                    switch (p.getName())
                    {
                        case "Books":
                        case "Fruits":
                        case "Vegetables":
                            sum+=(p.getPrice()*bookFruitVegetable);
                            System.out.println(p.getName()+", price: "+String.format("%.2f",p.getPrice())+" zł"+", price(+vat): "+String.format("%.2f", (p.getPrice()*bookFruitVegetable)));
                            break;

                        case "Newspapers":
                            sum+=(p.getPrice()*newspaper);
                            System.out.println(p.getName()+", price: "+String.format("%.2f",p.getPrice())+" zł"+", price(+vat): "+String.format("%.2f", (p.getPrice()*newspaper)));
                            break;

                        case "SeaFood":
                            sum+=(p.getPrice()*seaFood);
                            System.out.println(p.getName()+", price: "+String.format("%.2f",p.getPrice())+" zł"+", price(+vat): "+String.format("%.2f", (p.getPrice()*seaFood)));
                            break;
                    }

                });
        System.out.println("Price with vat "+String.format("%.2f",sum));

    }

    public double getBookFruitVegetable() {
        return bookFruitVegetable;
    }

    public void setBookFruitVegetable(double bookFruitVegetable) {
        this.bookFruitVegetable = bookFruitVegetable;
    }

    public double getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(double newspaper) {
        this.newspaper = newspaper;
    }

    public double getSeaFood() {
        return seaFood;
    }

    public void setSeaFood(double seaFood) {
        this.seaFood = seaFood;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}