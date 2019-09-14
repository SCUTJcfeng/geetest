package com.jc.geetest.sdk;

import com.alibaba.fastjson.JSON;
import com.jc.geetest.sdk.entity.GeetestRegisterEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;
import lombok.Data;

/**
 * GeetestLib
 */
public class GeetestLib {
    private final String apiUrl = "http://api.geetest.com";
    private final String registerUrl = apiUrl + "/register.php?json_format=1&gt=";
    private final String validateUrl = apiUrl + "/validate.php";

    /**
     * 公钥
     */
    private String captchaId = "";

    /**
     * 私钥
     */
    private String privateKey = "";

    /**
     * 极验验证API服务状态Session Key
     */
    public String gtServerStatusSessionKey = "gt_server_status";

    private RestTemplate restTemplate;

    public GeetestLib(String captchaId, String privateKey, RestTemplate restTemplate) {
        this.captchaId = captchaId;
        this.privateKey = privateKey;
        this.restTemplate = restTemplate;
    }

    public GeetestRegisterEntity register() {
        String responseStr =
                restTemplate.getForObject(registerUrl + captchaId, String.class, captchaId);
        System.out.println("register response: " + responseStr);
        RegisterResponse response = JSON.parseObject(responseStr, RegisterResponse.class);
        String challenge = md5(response.getChallenge() + this.privateKey);
        GeetestRegisterEntity entity =
                new GeetestRegisterEntity().setChallenge(challenge).setSuccess(1).setGt(captchaId);
        return entity;
    }

    public Boolean validate(String challenge, String validate, String seccode) {
        if (!(checkValidateParam(challenge, validate))) {
            return false;
        }
        String mapString = String.format("challenge=%s&validate=%s&seccode=%s&json_format=1",
                challenge, validate, seccode);
        String responseStr =
                restTemplate.postForObject(validateUrl + "?" + mapString, null, String.class);
        System.out.println("validate response: " + responseStr);
        ValidateResponse response = JSON.parseObject(responseStr, ValidateResponse.class);
        String resSeccode = response.getSeccode();
        if (resSeccode.equals("false")) {
            return false;
        }
        return resSeccode.equals(md5(seccode));
    }

    private Boolean checkValidateParam(String challenge, String validate) {
        return validate.equals(md5(privateKey + "geetest" + challenge));
    }

    private String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    @Data
    public static class RegisterResponse {
        private String challenge;
    }

    @Data
    public static class ValidateResponse {
        private String seccode;
    }
}
