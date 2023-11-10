package com.junkfoood.reponsitory;

import com.junkfoood.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReponsitory extends JpaRepository<OrderEntity,Integer> {

    @Query("SELECT o FROM OrderEntity o WHERE o.account.username=?1")
    List<OrderEntity> findByUsername (String username);

}
