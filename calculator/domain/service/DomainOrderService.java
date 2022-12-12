package com.example.demo.domain.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.Product;
import com.example.demo.domain.repository.OrderRepository;

//import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(final Product product) {
        final Order order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void addProduct(final UUID id, final Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(final UUID id, final UUID productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
          .findById(id)
          .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }

    
    
    
    
    
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository
		.findAll();
		}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Product> findAllProducts() {
//		// TODO Auto-generated method stub
//		return orderRepository
//				.findAll();
//		}
//	

//	@Override
//	public List<Product> findAllProducts() {
//		// TODO Auto-generated method stub
//		List<Order> ordenes = orderRepository
//				.findAll();
//		
//		List<Product> productos = new ArrayList()<>();
//		for( Order o : ordenes ) {
//			for ( Product p : o.getOrderItems()) {
//				
//			}
////			productos.add(o.)
//		}
//		
//		return orderRepository
//				.findAll();
//	}
}
