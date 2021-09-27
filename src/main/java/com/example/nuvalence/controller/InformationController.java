package com.example.nuvalence.controller;

import com.example.nuvalence.domain.User;
import com.example.nuvalence.dto.InformationDTO;
import com.example.nuvalence.dto.UserDataDTO;
import com.example.nuvalence.service.InformationService;
import com.example.nuvalence.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

@Slf4j
@RestController
public class InformationController {

    private final InformationService service;
    private UserService userService;

    public InformationController(InformationService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @ApiOperation(value = "Analyse rectangles provided")
    @PostMapping(value = "rectangles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processInformationFromRectangles(@RequestBody InformationDTO information) {
        log.info("Entering method processInformationFromRectangles");
        ResponseEntity<String> result;

        String messageDTO = service.analyseRectangles(information);
        result = new ResponseEntity<>(messageDTO, HttpStatus.OK);

        log.info("Exiting method processInformationFromRectangles");
        return result;
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    public String signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        return userService.getToken(modelMapper.map(user, User.class));
    }
}
