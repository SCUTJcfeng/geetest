package com.jc.geetest.service;

/**
 * GeetestService
 */
public interface GeetestService {

    String register();

    Integer validate(String challenge, String validate, String seccode);
}
