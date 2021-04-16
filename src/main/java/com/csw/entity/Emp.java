package com.csw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor

public class Emp implements Serializable {
    private String id;//varchar(99),
    private String name;// varchar(99),
    private String salary;// varchar(99),
    private String age;// varchar(99),
    @DateTimeFormat(pattern = "YYYY/MM/dd")
    @JsonFormat(pattern = "YYYY/MM/dd HH:mm:ss",timezone ="GMT+8")
    private Date bir;// DATE,
    private String did;// varchar(99)
    private Dept dept;
}
