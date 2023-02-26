package com.programing.springbootjpa.service;

import com.programing.springbootjpa.dto.MerchantDTO;
import com.programing.springbootjpa.model.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MerchantService {
    Merchant create(Merchant merchant);
    Merchant update(Long id, Merchant merchant);
    Boolean delete(Long id);
    List<Merchant> findAll();

    Page<Merchant> findAll(Pageable pageable);

    Merchant findById(Long id);

    MerchantDTO mapToDto(Merchant merchant);
    Merchant mapToEntity(MerchantDTO merchantDTO);
}
