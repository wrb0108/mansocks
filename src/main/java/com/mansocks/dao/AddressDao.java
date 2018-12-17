package com.mansocks.dao;

import com.mansocks.entity.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    @Select("SELECT * from address where userid=#{userid}")
    List<Address> select(int userid);
    int add(Address address);
    int del(int addressid);

}
