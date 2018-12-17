package com.mansocks.service;

import com.mansocks.dao.AddressDao;
import com.mansocks.entity.Address;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    @Override
    public List<Address> select(int userid) {
        return addressDao.select(userid);
    }

    @Override
    public void add(Address address) {

       addressDao.add(address);
    }

    @Override
    public void del(int addressid) {
       addressDao.del(addressid);
    }
}
