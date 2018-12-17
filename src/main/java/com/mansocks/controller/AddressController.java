package com.mansocks.controller;

import com.mansocks.entity.Address;
import com.mansocks.service.AddressService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @ApiOperation(value = "地址信息")
    @RequestMapping(value = "massager",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1,message = "操作成功"),@ApiResponse(code = 0,message = "操作失败"),@ApiResponse(code = 3,message = "权限不足")})
    @ApiImplicitParams({
    })
    public List<Address> selece(int userid){
        List<Address> list=addressService.select(userid);
        return list;
    }
}
