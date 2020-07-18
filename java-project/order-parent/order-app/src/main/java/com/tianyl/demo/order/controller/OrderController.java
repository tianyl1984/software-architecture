package com.tianyl.demo.order.controller;

import com.tianyl.demo.order.facade.OrderFacade;
import com.tianyl.demo.order.view.OrderDetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderFacade orderFacade;

    @RequestMapping("/listAll")
    public List<OrderDetailView> listAll() {
        return orderFacade.listAll();
    }

}
