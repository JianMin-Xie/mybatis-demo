package com.xjm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   
   private int id;  //id
   private String name;   //姓名
   private String password;   //密码

}