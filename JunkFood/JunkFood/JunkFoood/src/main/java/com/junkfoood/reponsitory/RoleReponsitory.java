package com.junkfoood.reponsitory;

import com.junkfoood.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReponsitory extends JpaRepository<RoleEntity,String> {
}
