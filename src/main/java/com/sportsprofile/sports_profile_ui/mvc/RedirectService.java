package com.sportsprofile.sports_profile_ui.mvc;

import org.springframework.stereotype.Service;

@Service
public class RedirectService {

    public String redirectToPolar(final String formUri, final String processReference) {
        return String.format("redirect:%s%s", formUri, processReference);
    }

}
