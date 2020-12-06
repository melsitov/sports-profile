package com.sportsprofile.sports_profile_ui.service;

import org.springframework.stereotype.Service;
import com.sportsprofile.polar_api.entity.TokenResponse;
import com.sportsprofile.sports_profile_ui.service.commands.SavePolarTokenCommand;

@Service
public class SportsProfileMapper {

    public SavePolarTokenCommand map (TokenResponse token){
        var command = new SavePolarTokenCommand();
        command.setAccessToken(token.getAccessToken());
        command.setTokenType(token.getTokenType());
        command.setXUserId(token.getXUserId());
        command.setExpiresIn(String.valueOf(token.getExpiresIn()));
        return command;
    }
}
