package com.jc.geetest.sdk.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * GeetestRegisterEntity
 */
@Data
@Accessors(chain = true)
public class GeetestRegisterEntity {

    private String challenge;

    private Integer success;

    private String gt;
}
