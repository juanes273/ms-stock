package com.bootcamp_2024.ms_stock.configuration;

import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.adapter.CategoryAdapter;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.mapper.CategoryEntityMapper;
import com.bootcamp_2024.ms_stock.adapters.driven.jpa.mysql.repository.CategoryRepository;
import com.bootcamp_2024.ms_stock.domain.api.CategoryServicePort;
import com.bootcamp_2024.ms_stock.domain.usecase.CategoryUseCase;
import com.bootcamp_2024.ms_stock.domain.spi.CategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public CategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public CategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

}
