package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order; //다른패키지에 있는 클래스를 쓸때 import를 사용함
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }
    // public List<Order> findAll(OrderSearch orderSearch){}
}
