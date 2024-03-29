package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.AccountType;
import edu.mum.cs.cs425.finalproject.senteapp.repository.AccountTypeRepository;
import edu.mum.cs.cs425.finalproject.senteapp.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImplementation implements AccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public Page<AccountType> getAllAccountTypes(int pageNo) {
        return accountTypeRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("accountTypeName")));
    }


    @Override
    public AccountType addNewAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType getAccountTypeById(Long accountTypeId) {
        return accountTypeRepository.findById(accountTypeId).orElse(null);
    }


    @Override
    public List<AccountType> getAllAccountTypesList() {
        return accountTypeRepository.findAll();
    }

}
