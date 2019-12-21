package com.adu21.spring.boot.global.param.trace.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 1223815941150270512L;
    private Long id;
    private String name;
}
