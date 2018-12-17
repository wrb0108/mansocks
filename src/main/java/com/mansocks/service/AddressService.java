package com.mansocks.service;

import com.mansocks.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> select(int userid);

    void add(Address address);

    void del(int addressid);
}
