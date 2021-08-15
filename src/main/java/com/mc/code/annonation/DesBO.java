package com.mc.code.annonation;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author macheng
 * @date 2021/1/18 16:27
 */
@Data
@Accessors(chain = true)
public class DesBO {
    @Email
    private String email;

}

