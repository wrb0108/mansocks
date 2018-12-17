package com.mansocks.controller;
import com.mansocks.entity.Address;
import com.mansocks.service.AddressService;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @ApiOperation(value = "地址信息")
    @RequestMapping(value = "/massager",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1,message = "操作成功"),@ApiResponse(code = 0,message = "操作失败"),@ApiResponse(code = 3,message = "权限不足")})
    @ApiImplicitParams({
    })
    public List<Address> selece(int userid){
        List<Address> list=addressService.select(userid);
        return list;
    }
    @ApiOperation(value = "添加地址")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiResponses({@ApiResponse(code = 1,message = "操作成功"),@ApiResponse(code = 0,message = "操作失败"),@ApiResponse(code = 3,message = "权限不足")})
    @ApiImplicitParams({
    })
    public String add(@ModelAttribute Address address,HttpServletRequest request){

        addressService.add(address);
        return "添加成功";
    }
    @ApiOperation(value = "删除地址")
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 1,message = "操作成功"),@ApiResponse(code = 0,message = "操作失败"),@ApiResponse(code = 3,message = "权限不足")})
    @ApiImplicitParams({
    })
    public String del(int addressid){
        addressService.del(addressid);
        return "删除成功";
    }
}
