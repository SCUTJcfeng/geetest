package com.jc.geetest.service.impl;

import com.jc.geetest.sdk.GeetestLib;
import com.jc.geetest.sdk.entity.GeetestRegisterEntity;
import com.jc.geetest.service.GeetestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GeetestServiceImpl
 */
@Service
public class GeetestServiceImpl implements GeetestService {

    @Autowired
    private GeetestLib geetestLib;

    @Override
    public GeetestRegisterEntity register() {
        return geetestLib.register();
    }

    @Override
    public Boolean validate(String challenge, String validate, String seccode) {
        return geetestLib.validate(challenge, validate, seccode);
    }
}
