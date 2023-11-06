package com.kadaijin.kadaijin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import com.kadaijin.kadaijin.model.DTO.RegisterDTO;
import com.kadaijin.kadaijin.repository.PersonalDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.LoginDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;

import jakarta.persistence.EntityManager;

@Service
public class AccountsService {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    PersonalDataRepository personalDataRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountsDTO accountsDTO;

     // REGISTER
    public void register(RegisterDTO registerDTO) {
        if (accountsRepository.findByEmails(registerDTO.getEmail()) != null) {
            System.out.println("Email udah ada bang!!");
        } else {

            AccountsModel accountsModel = new AccountsModel(
                    registerDTO.getEmail(),
                    registerDTO.getPassword());
            this.accountsRepository.save(accountsModel);

            int accounts_id = accountsRepository.findIdByEmail(registerDTO.getEmail());

            LogModel logModel = new LogModel(accounts_id);
            this.logRepository.save(logModel);

            PersonalDataModel personalDataModel = new PersonalDataModel(
                    registerDTO.getName(),
                    registerDTO.getAge(),
                    registerDTO.getPhone(),
                    registerDTO.getCountry(),
                    registerDTO.getCity(),
                    accounts_id);
            this.personalDataRepository.save(personalDataModel);
        }
    }

    // LOGIN
    public void login(LoginDTO loginDTO) {
        if (accountsRepository.existsByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword())) {
            System.out.println(accountsRepository.findIdByEmail(loginDTO.getEmail()));
            LogModel logModel = new LogModel(accountsRepository.findIdByEmail(loginDTO.getEmail()));
            logRepository.save(logModel);
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

    // GET ONE ACCOUNT
    public AccountsDTO getOne(String req) {
        try {
            Integer id = Integer.parseInt(req);
            Optional<AccountsModel> optional = accountsRepository.findById(id);
            AccountsDTO dto = new AccountsDTO(optional.get(), Collections.emptyList());
            return dto;
        } catch (Exception e) {
            AccountsDTO accountsDTO = new AccountsDTO(accountsRepository.findByEmails(req), Collections.emptyList());
            return accountsDTO;
        }
    }

    // GET ALL ACCOUNT
    public List<AccountsDTO> getData() {
        List<AccountsModel> findAll = accountsRepository.findAll();
        return accountsDTO.listEntityToDto(findAll);
    }

    // GET ACCOUNT WITH PAGGING
    public List<AccountsDTO> getPages(Integer page, Integer size) {
        List<AccountsModel> accountsModels = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size); // sistem untuk membaut paging
        Page<AccountsModel> pageResult = accountsRepository.findByPage(pageable);

        for (AccountsModel accountsModel : pageResult) {
            accountsModel.setLogs(null);
            accountsModels.add(accountsModel);
        }

        return accountsDTO.listEntityToDto(accountsModels);
    }
}
