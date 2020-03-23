package com.kackan.zad_dom_tydz2.service;
import com.kackan.zad_dom_tydz2.entity.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("start")
public class ShopStart extends ShopBasic implements Shop{

}
