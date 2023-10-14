package com.kadaijin.kadaijin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<KadaijinDTO> getData() {
        List<KadaijinModel> findAll = kadaijinRepository.findAll();
        List<KadaijinDTO> dataDTO = new ArrayList<>();

        for (KadaijinModel kadaijinModel : findAll) {
            KadaijinDTO dto = new KadaijinDTO();
            dataDTO.add(dto.entityToDto(kadaijinModel));
        }

        return dataDTO;
    }

    public KadaijinDTO getOne(Integer no) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        Optional<KadaijinModel> optional = kadaijinRepository.findById(no);
        KadaijinModel kadaijinModel = optional.get();
        return kadaijinDTO.entityToDto(kadaijinModel);
    }

    public List<KadaijinDTO> getPages(Integer page, Integer size) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        Pageable pageable = PageRequest.of(page, size); // sistem untuk membaut paging
        Page<KadaijinModel> pageResult = kadaijinRepository.findAll(pageable);
        kadaijinDTO.entityToDto(pageResult);
        return pageResult.getContent();
    }

}
