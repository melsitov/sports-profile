package com.sportsprofile.sports_profile_ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportsprofile.sports_profile_core.service.SportsProfileCoreCommandService;
import com.sportsprofile.sports_profile_ui.service.commands.SavePolarTokenCommand;

@Service
public class SportsProfileCommandService {

    @Autowired
    private SportsProfileCoreCommandService commandService;

    public void savePolarToken(final SavePolarTokenCommand command) {
        commandService.savePolarToken(command);
    }
}
