package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;

@Service
public class GetService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    KadaijinDTO kadaijinDTO;

    @Autowired
    ModelMapper modelMapper;

    public List<KadaijinDTO> getData() {
        List<KadaijinModel> findAll = kadaijinRepository.findAll();

        return kadaijinDTO.listEntityToDto(findAll);
    }

    public KadaijinDTO getOne(Integer no) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        Optional<KadaijinModel> optional = kadaijinRepository.findById(no);
        KadaijinDTO dto = modelMapper.map(optional, KadaijinDTO.class);
        KadaijinModel kadaijinModel = optional.get();
        return dto;

    }

    public List<KadaijinDTO> getPages(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size); // sistem untuk membaut paging
        Page<KadaijinModel> pageResult = kadaijinRepository.findAll(pageable);

        return kadaijinDTO.listEntityToDto(pageResult);
    }

}
