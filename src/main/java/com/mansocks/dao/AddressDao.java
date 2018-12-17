package com.mansocks.dao;

import com.mansocks.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    @Select("SELECT * from address where userid=#{userid}")
    List<Address> select(int userid);

    @Insert("insert into address (province,area,street,userid) values (#{province},#{area},#{street},#{userid})")
    void add(Address address);

    @Delete("delete from address where addressid=#{addressid}")
    void del(int addressid);

}
