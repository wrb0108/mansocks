package com.mansocks.service;

import com.mansocks.dao.AddressDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl {
    @Resource
    private AddressDao addressDao;

}
