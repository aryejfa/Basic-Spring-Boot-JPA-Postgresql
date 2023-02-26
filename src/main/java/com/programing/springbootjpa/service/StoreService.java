package com.programing.springbootjpa.service;

import com.programing.springbootjpa.dto.StoreDTO;
import com.programing.springbootjpa.model.Store;

public interface StoreService {

    Store addStore(Long merchantId, Store store);
    StoreDTO mapToDto(Store store);
    Store mapToEntity(StoreDTO storeDTO);

}
