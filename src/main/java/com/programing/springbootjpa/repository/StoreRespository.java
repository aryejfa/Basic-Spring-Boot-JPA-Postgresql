package com.programing.springbootjpa.repository;

import com.programing.springbootjpa.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRespository extends JpaRepository<Store, Long> {
}
