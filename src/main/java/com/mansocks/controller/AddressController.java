package com.mansocks.controller;

import com.mansocks.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

}
