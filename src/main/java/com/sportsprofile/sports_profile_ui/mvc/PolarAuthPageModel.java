package com.sportsprofile.sports_profile_ui.mvc;

import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PolarAuthPageModel {

    @NotBlank
    private String clientId;
    @NotBlank
    private String clientSecret;
}
