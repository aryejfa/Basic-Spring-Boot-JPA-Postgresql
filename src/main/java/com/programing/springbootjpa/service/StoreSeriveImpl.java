package com.programing.springbootjpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programing.springbootjpa.dto.MerchantDTO;
import com.programing.springbootjpa.dto.StoreDTO;
import com.programing.springbootjpa.model.Merchant;
import com.programing.springbootjpa.model.Store;
import com.programing.springbootjpa.repository.StoreRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StoreSeriveImpl implements StoreService{
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MerchantService merchantService;

    @Autowired
    StoreRespository storeRespository;

    @Override
    public Store addStore(Long merchantId, Store store) {
        final Merchant merchant = merchantService.findById(merchantId);

        if(merchant != null){
            // add store to db
            store = storeRespository.save(store);

            if(merchant.getStores() != null){
                List<Store> stores = merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            }else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant);
            return store;
        }
        return  null;
    }

    @Override
    public StoreDTO mapToDto(Store store) {
        return mapper.convertValue(store, StoreDTO.class);
    }

    @Override
    public Store mapToEntity(StoreDTO storeDTO) {
        return mapper.convertValue(storeDTO, Store.class);
    }
}
