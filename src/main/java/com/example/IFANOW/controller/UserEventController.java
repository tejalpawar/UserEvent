package com.example.IFANOW.controller;

import com.example.IFANOW.constant.EmailConstant;
import com.example.IFANOW.model.EmailPool;
import com.example.IFANOW.model.UserEventInfo;
import com.example.IFANOW.service.EmailPoolService;
import com.example.IFANOW.service.UserEventInfoService;
import com.example.IFANOW.utility.NotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Api(value = "Swagger2RestController", description = "REST APIs related to User Event Entity!!!!")
@RestController
@RequestMapping("/api")
public class UserEventController {


    @Autowired
    private UserEventInfoService UserEventInfoService;

    @ApiOperation(value = "Get list of User in the System ", response = Iterable.class, tags = "getuserEvent")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<String>> listAllUsers(@RequestBody UserEventInfo userinfo) {
        System.out.println("USER EVENT API IS CALLED...");
        String response = UserEventInfoService.submitUserEventInfo(userinfo);
        return new ResponseEntity<List<String>>(Collections.singletonList(response), HttpStatus.OK);
    }
}
