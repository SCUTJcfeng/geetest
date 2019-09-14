package com.jc.geetest.service;

import com.jc.geetest.sdk.entity.GeetestRegisterEntity;

/**
 * GeetestService
 */
public interface GeetestService {

    GeetestRegisterEntity register();

    Boolean validate(String challenge, String validate, String seccode);
}
