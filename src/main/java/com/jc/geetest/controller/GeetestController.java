package com.jc.geetest.controller;

import com.jc.geetest.form.GeetestValidateForm;
import com.jc.geetest.service.GeetestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GeetestController
 */
@RestController
@RequestMapping("api/geetest")
public class GeetestController {

    @Autowired
    private GeetestService geetestService;

    @GetMapping("register")
    public String register() {
        return geetestService.register();
    }

    @PostMapping("validate")
    public Integer validate(@RequestBody GeetestValidateForm form) {
        return geetestService.validate(form.getChallenge(), form.getValidate(), form.getSeccode());
    }
}
