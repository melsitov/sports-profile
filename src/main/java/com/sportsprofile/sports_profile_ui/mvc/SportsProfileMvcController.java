package com.sportsprofile.sports_profile_ui.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.sportsprofile.polar_api.client.PolarClient;
import com.sportsprofile.sports_profile_ui.service.SportsProfileCommandService;
import com.sportsprofile.sports_profile_ui.service.SportsProfileMapper;

@Controller
public class SportsProfileMvcController {

    private static final String CLIENT_ID = "19e6d41c-f2e9-44a0-bce5-8509823b2cfc";
    private static final String SECRET = "dbe2674f-5dbd-40c9-80aa-c16f0521b140";

    @Autowired
    public PolarClient polarClient;
    @Autowired
    public SportsProfileMapper mappingService;
    @Autowired
    public SportsProfileCommandService commandService;

    @GetMapping
    public ModelAndView initApp() {
        final ProfileInitModel model = new ProfileInitModel();
        model.setPolarLink(SportsProfile.Uri.POLAR_AUTH_PAGE);
        final ModelAndView modelAndView = new ModelAndView(SportsProfile.View.SPORTS_PROFILE);
        modelAndView.addObject(SportsProfile.Model.SPORTS_PROFILE, model);
        return modelAndView;
    }

    @GetMapping(SportsProfile.Uri.POLAR_AUTH_PAGE)
    public ModelAndView getPolarAuthPage(){
        final ModelAndView modelAndView = new ModelAndView(SportsProfile.View.POLAR_AUTH);
        modelAndView.addObject(SportsProfile.Model.POLAR_AUTH, new PolarAuthPageModel());
        return modelAndView;
    }

//    @GetMapping
//    public String receiveResponse(@RequestParam(value = SportsProfile.Uri.RESPONSE_CODE_NUMBER, defaultValue = "code") String code) {
//        final TokenResponse token = polarClient.getToken(code, CLIENT_ID, SECRET);
//        final SavePolarTokenCommand command = mappingService.map(token);
//        commandService.savePolarToken(command);
//
//        return code + token;
//    }
}
