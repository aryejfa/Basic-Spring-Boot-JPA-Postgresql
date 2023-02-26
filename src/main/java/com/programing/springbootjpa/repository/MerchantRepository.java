package com.programing.springbootjpa.repository;

import com.programing.springbootjpa.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
