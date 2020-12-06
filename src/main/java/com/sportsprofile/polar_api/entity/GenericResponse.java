package com.sportsprofile.polar_api.entity;

import lombok.Data;

@Data
public class GenericResponse {

    private boolean isSuccess;
    private String error;
}

