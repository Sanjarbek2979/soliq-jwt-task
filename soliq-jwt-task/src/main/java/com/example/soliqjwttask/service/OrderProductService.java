package com.example.soliqjwttask.service;

import com.example.soliqjwttask.dto.ApiResponse;
import com.example.soliqjwttask.dto.OrderProductDto;
import com.example.soliqjwttask.entity.Order;
import com.example.soliqjwttask.entity.OrderProduct;
import com.example.soliqjwttask.entity.Product;
import com.example.soliqjwttask.repository.OrderProductRepository;
import com.example.soliqjwttask.repository.OrderRepository;
import com.example.soliqjwttask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductService {


    @Autowired
    OrderProductRepository orderProductRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;


    public ApiResponse all() {
        List<OrderProduct> all = orderProductRepository.findAll();
        return new ApiResponse("Mana", true, all);
    }


    public ApiResponse getOneId(Integer id) {
        Optional<OrderProduct> byId = orderProductRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Bunday id li mavjud emas", false);
        }
        return new ApiResponse("Mana", true, byId.get());
    }


//    public ApiResponse add(OrderProductDto orderProductDto) {
//        OrderProduct orderProduct=new OrderProduct();
//        Optional<Order> orderOptional = orderRepository.findById(orderProductDto.getOrderId());
//        if (!orderOptional.isPresent()) {
//            return new ApiResponse("Bunday id li order mavjud emas",false);
//        }
//        orderProduct.setOrder(orderOptional.get());
//
//        Optional<Product> productOptional = productRepository.findById(orderProductDto.getProductId());
//        if (!productOptional.isPresent()) {
//            return new ApiResponse("Bunday id li product mavjud emas",false);
//        }
//        orderProduct.setProduct(productOptional.get());
//        orderProduct.setAmount(orderProductDto.getAmout());
//
//        OrderProduct save = orderProductRepository.save(orderProduct);
//        return new ApiResponse("Qo'shildi",true,save);
//    }


//    public ApiResponse edit(Integer id, OrderProductDto orderProductDto) {
//        Optional<OrderProduct> byId = orderProductRepository.findById(id);
//        if (!byId.isPresent()) {
//            return new ApiResponse("Bunday id li oorder product mavjud emas", false);
//        }
//
//        OrderProduct orderProduct = byId.get();
//        orderProduct.setProduct(productRepository.getById(orderProductDto.getOrderId()));
//        orderProduct.setOrder(orderRepository.getById(orderProductDto.getOrderId()));
//        orderProduct.setAmount(orderProductDto.getAmout());
//        OrderProduct save = orderProductRepository.save(orderProduct);
//        return new ApiResponse("O'zgartirildi", true, save);
//    }


    public ApiResponse delet(Integer id) {
        Optional<OrderProduct> byId = orderProductRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Bunday id li order product mavjud emas", true);
        }
        orderProductRepository.deleteById(id);
        return new ApiResponse("O'chirildi", true);
    }
}
