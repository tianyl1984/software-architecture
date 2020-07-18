package com.tianyl.demo.order.facade;

import com.tianyl.demo.order.entity.Order;
import com.tianyl.demo.order.mapper.OrderMapper;
import com.tianyl.demo.order.view.OrderDetailView;
import com.tianyl.demo.userClient.dto.UserDto;
import com.tianyl.demo.userClient.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderFacade {

    @Autowired
    private IUserService userService;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDetailView> listAll() {
        List<Order> allOrders = orderMapper.selectAll();
        List<OrderDetailView> result = new ArrayList<>();
        for (Order order : allOrders) {
            OrderDetailView view = new OrderDetailView();
            view.setOrderId(order.getId());
            view.setOrderDate(order.getOrderDate());
            view.setAmount(order.getAmount());
            view.setUserId(order.getUserId());
            UserDto userDto = userService.getUser(order.getUserId());
            view.setUsername(userDto.getUsername());
            result.add(view);
        }
        return result;
    }
}
