package com.services.account.controller;


import com.services.account.dto.AccountDto;
import com.services.account.dto.AccountReq;
import com.services.account.dto.AccountUpdateDto;
import com.services.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") String id){
        return ResponseEntity.ok(this.accountService.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountReq accountReq){
        return new ResponseEntity<>(this.accountService.createAccount(accountReq), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(
            @PathVariable("id") String id,
            @RequestBody AccountUpdateDto updateDto
    ){
        return ResponseEntity.ok(this.accountService.updateAccount(id,updateDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDto> deleteAccount(@PathVariable("id") String id){
        return ResponseEntity.ok(this.accountService.deleteAccount(id));
    }


}
