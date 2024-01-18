package com.ms.user.controller;

import com.ms.user.dto.EmailDTO;
import com.ms.user.dto.UserDTO;
import com.ms.user.model.User;
import com.ms.user.service.EmailService;
import com.ms.user.service.ServiceUser;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/")
public class ControllerUser {

    @Autowired
    ServiceUser serviceUser;

    @Autowired
    EmailService emailService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO userDTO){
        var user = new User();
        BeanUtils.copyProperties(userDTO,user);
        var responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.serviceUser.create(user));
        var email = new EmailDTO(user.getNome(),user.getEmail(),"Olá " +user.getNome()+ ",você acabou de realizar o seu cadastro");
        this.emailService.sendMensagem("email",email);
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(this.serviceUser.getAll().stream()
                        .map(user-> new UserDTO(user.getNome(), user.getEmail()))
                        .toList());
    }

}
