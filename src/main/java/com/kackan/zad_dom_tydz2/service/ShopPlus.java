package com.kackan.zad_dom_tydz2.service;

import com.kackan.zad_dom_tydz2.entity.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConfigurationProperties(prefix = "vat")
@Profile("plus")
public class ShopPlus implements Shop{

    private double bookFruitVegetable;
    private double newspaper;
    private double seaFood;

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

        System.out.println("PLUS");


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


        System.out.println("Sum(with vat): "+String.format("%.2f",sum));
    }

    @Override
    public double getRandomPrice() {
        double min = 50;
        double max = 300;
        double price = (Math.random() * ((max - min) + 1)) + min;
        return price;
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
}