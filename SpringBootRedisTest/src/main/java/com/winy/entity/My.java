package com.winy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class My implements Serializable {
   private String name;
   private Integer age;
   private Double scour;
   private Date birthday;
}
