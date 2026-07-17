package com.wms.enterprisewms.dto;

import com.wms.enterprisewms.entity.Role;
import lombok.Data;


@Data
public class RegisterRequest {


    private String username;


    private String password;


    private Role role;

}