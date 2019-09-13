package com.jc.geetest.service.impl;

import java.io.UnsupportedEncodingException;
import com.jc.geetest.sdk.GeetestLib;
import com.jc.geetest.service.GeetestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * GeetestServiceImpl
 */
@Service
@Slf4j
public class GeetestServiceImpl implements GeetestService {

    @Autowired
    private GeetestLib geetestLib;

    @Override
    public String register() {
        int status = geetestLib.preProcess();
        log.info(String.valueOf(status));
        String result = geetestLib.getResponseStr();
        log.info(result);
        return result;
    }

    @Override
    public Integer validate(String challenge, String validate, String seccode) {
        int status = 0;
        try {
            status = geetestLib.enhencedValidateRequest(challenge, validate, seccode, null);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info(String.valueOf(status));
        return status;
    }
}
