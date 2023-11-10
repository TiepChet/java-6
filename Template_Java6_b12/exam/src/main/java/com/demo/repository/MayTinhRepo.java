package com.demo.repository;

import com.demo.model.MayTinh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MayTinhRepo extends JpaRepository<MayTinh, UUID> {
}
