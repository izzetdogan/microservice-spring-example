package com.services.account.service;

import com.services.account.dto.AccountDto;
import com.services.account.dto.AccountReq;
import com.services.account.dto.AccountUpdateDto;
import com.services.account.entity.Account;
import com.services.account.exception.AccountNotFoundException;
import com.services.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto getAccountById(String id){
        return AccountDto.convert(findAccountById(id));
    }

    public AccountDto createAccount(AccountReq req){
        Account account = new Account(req.getUsername(), req.getEmail(), req.getPassword());
        return AccountDto.convert(this.accountRepository.save(account));
    }

    public AccountDto updateAccount(String id, AccountUpdateDto updateDto){
        Account find = findAccountById(id);
        Account newOne = this.accountRepository.save(
                new Account(
                        find.getId(),
                        find.getUsername(),
                        find.getEmail(),
                        updateDto.getPassword())
        );
        return AccountDto.convert(newOne);

    }

    public AccountDto deleteAccount(String id){
        Account find = findAccountById(id);
        this.accountRepository.delete(find);
        return AccountDto.convert(find);

    }


    private Account findAccountById(String id){
        return this.accountRepository.findById(id)
                .orElseThrow(()-> new AccountNotFoundException("Account", "account id", id));
    }


}
