package com.sportsprofile.sports_profile_ui.mvc;

public interface SportsProfile {

    interface Uri {
        String SPORTS_PROFILE = "/sports-profile";
        String POLAR_AUTH_PAGE = SPORTS_PROFILE + "/polar-auth";
        String POLAR_OAUTH_LINK = "https://flow.polar.com/oauth2/authorization?response_type=code&client_id=";
    }

    interface View {
        String SPORTS_PROFILE = "sports-profile";
        String POLAR_AUTH = "sports-profile-polar-auth";
    }

    interface Model {
        String PROFILE_REFERENCE = "profileReference";
        String SPORTS_PROFILE = "sportsProfile";
        String POLAR_AUTH = "polarAuth";
    }

}
