package com.mvc.login.controller;

import com.mvc.login.dto.TransferDto;
import com.mvc.login.service.IMoneyTransferService;
import com.mvc.login.util.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MoneyTransferController
 */
@RestController
@RequestMapping("/restful/transfer")
public class MoneyTransferController {

    @Autowired
    IMoneyTransferService service;

    /**
     * transfer money from one account to another, it could be to different user as
     * well
     * 
     * @param transferDto data for transfering money
     */
    @PostMapping
    public GenericResponse transferMoney(@RequestBody TransferDto transferData) throws Exception {

        return new GenericResponse(null, null, service.transferMoney(transferData));

    }
}