package com.sportsprofile.sports_profile_ui.service.commands;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SavePolarTokenCommand {

    private String sportsProfileId;
    private String accessToken;
    private String tokenType;
    private String expiresIn;
    private String xUserId;
}
