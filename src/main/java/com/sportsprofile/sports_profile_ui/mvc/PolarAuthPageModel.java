package com.sportsprofile.sports_profile_ui.mvc;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class PolarAuthPageModel {

    @NotNull
    private String clientId;
    @NotNull
    private String clientSecret;
}
