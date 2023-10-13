package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;

@Service
public class GetService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    public List<KadaijinModel> getData() {
        return kadaijinRepository.findAll();
    }

    public Optional<KadaijinModel> getOne(Integer no) {
        return kadaijinRepository.findById(no);
    }

    public List<KadaijinModel> getPages(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KadaijinModel> pageResult = kadaijinRepository.findAll(pageable);
        return pageResult.getContent();
    }

}
