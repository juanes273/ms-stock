package com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.repository;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByNameContaining(String name);
    Optional<CategoryEntity> findByName(String name);
    Page<CategoryEntity> findAllByOrderByNameAsc(Pageable pageable);
    Page<CategoryEntity> findAllByOrderByNameDesc(Pageable pageable);
}
