package com.programing.springbootjpa.controller;

import com.programing.springbootjpa.dto.MerchantDTO;
import com.programing.springbootjpa.model.Merchant;
import com.programing.springbootjpa.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/create")
    public MerchantDTO create(@RequestBody MerchantDTO request){
        final Merchant merchant = merchantService.mapToEntity(request);
        final  Merchant result = merchantService.create(merchant);
        return  merchantService.mapToDto(result);
    }

    @PutMapping("/update/{id}")
    public  MerchantDTO update(@PathVariable Long id, @RequestBody MerchantDTO request){
        final Merchant merchant = merchantService.mapToEntity(request);
        final  Merchant result = merchantService.update(id, merchant);
        return  merchantService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<MerchantDTO> findAll(){
        return merchantService.findAll().stream().map(merchant -> merchantService.mapToDto(merchant))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public Page<MerchantDTO> findAllWithPagination(@PageableDefault Pageable pageable){
        return merchantService.findAll(pageable).map(merchant -> merchantService.mapToDto(merchant));
    }

    @DeleteMapping("/delete/{id}")
    public  Boolean delete(@PathVariable Long id){
        return  merchantService.delete(id);
    }
}
