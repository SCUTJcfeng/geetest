package com.jc.geetest.controller;

import com.jc.geetest.form.GeetestValidateForm;
import com.jc.geetest.sdk.entity.GeetestRegisterEntity;
import com.jc.geetest.service.GeetestService;
import com.jc.geetest.vo.GeetestRegisterVO;
import org.springframework.beans.BeanUtils;
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
    public GeetestRegisterVO register() {
        GeetestRegisterEntity entity = geetestService.register();
        GeetestRegisterVO vo = new GeetestRegisterVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @PostMapping("validate")
    public Boolean validate(@RequestBody GeetestValidateForm form) {
        return geetestService.validate(form.getChallenge(), form.getValidate(), form.getSeccode());
    }
}
