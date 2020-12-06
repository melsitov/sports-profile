package com.sportsprofile.polar_api.settings;

public interface Polar {

    interface Uri {
        String POLAR_URL = "https://flow.polar.com";
        String AUTH_TOKEN_ENDPOINT_URL = "https://polarremote.com/v2/oauth2/token";
        String LOGIN_URL = POLAR_URL + "/login";
        String TRAINING_URL = POLAR_URL + "/api/training/history";
        String TCX_URL = POLAR_URL + "/api/export/training/tcx";
        String GPX_URL = POLAR_URL + "/api/export/training/gpx";
        String CSV_URL = POLAR_URL + "/api/export/training/csv";
    }

    interface SportId {
        int SPORT_ID_RUNNING = 1;
        int SPORT_ID_MOUNTAIN_BIKING = 5;
        int SPORT_ID_STRENGTH_TRAINING = 15;
        int SPORT_ID_OTHER_OUTDOOR = 16;
        int SPORT_ID_INDOOR_CYCLING = 18;
        int SPORT_ID_INLINE_SKATING = 29;
        int SPORT_ID_ROAD_CYCLING = 38;
    }

    interface Token {
        String CONTENT_TYPE = "application/x-www-form-urlencoded";
        String ACCEPT = "application/json;charset=UTF-8";
    }
}
