package com.junkfoood.reponsitory;

import com.junkfoood.model.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReponsitory extends JpaRepository<ProductEntity,Integer> {

    @Query("SELECT p FROM ProductEntity p WHERE p.category.id=?1")
    List<ProductEntity> findByCategoryId(Integer cid);

    Page<ProductEntity> findByAvailableEquals(Integer available, Pageable pageable);


}
