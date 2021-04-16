package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by HIAPAD on 2019/10/30.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String username;// varchar(99),
    private String truename;// varchar(99),
    private String password;// varchar(99),
    private String salt;// varchar(99),
    private String sex;//varchar(99)
}
