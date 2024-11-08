package com.ltadcrm.ltadcrm.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltadcrm.ltadcrm.config.security.TokenService;
import com.ltadcrm.ltadcrm.domain.Account;
import com.ltadcrm.ltadcrm.domain.DTO.authentication.AuthenticationDTO;
import com.ltadcrm.ltadcrm.domain.DTO.authentication.RegisterDTO;
import com.ltadcrm.ltadcrm.repository.security.AccountRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private  AuthenticationManager authenticationManager;


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO data, HttpServletResponse response) {
        try{
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            System.out.println("tentativa de login registrada");
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generatedToken((Account)auth.getPrincipal());
            return  ResponseEntity.ok(token);
            
        }
        catch(Exception e){
            return new ResponseEntity<>("erro >> "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO register) {
        if (this.accountRepository.findByLogin(register.login()) != null)return new ResponseEntity<>("Usuário já existente localizado", HttpStatus.BAD_REQUEST);

        String encrypt = new BCryptPasswordEncoder().encode(register.password());
        Account user = new Account(register.login(), encrypt, register.role());

        this.accountRepository.save(user);
        return new ResponseEntity<>("Usuario cadastrado com sucesso no sistema", HttpStatus.OK);

    }

    @GetMapping("/teste")
    public ResponseEntity<String> getMethodName() {
        try{
            return new ResponseEntity<>("Teste de login",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Nao autorizado "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    
    }
}


