package com.sportsprofile.sports_profile_ui.mvc;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sportsprofile.polar_api.client.PolarClient;
import com.sportsprofile.polar_api.entity.TokenResponse;
import com.sportsprofile.sports_profile_ui.service.SportsProfileCommandService;
import com.sportsprofile.sports_profile_ui.service.SportsProfileMapper;
import com.sportsprofile.sports_profile_ui.service.commands.SavePolarTokenCommand;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping
public class SportsProfileMvcController {

    private static final String CLIENT_ID = "723d8559-f37f-4f62-a9e7-d94040f1f1d3";
    private static final String SECRET = "23c6fc88-37d9-4bda-838a-c90800b51b36";

    public PolarClient polarClient;
    public SportsProfileMapper mappingService;
    public SportsProfileCommandService commandService;
    public RedirectService redirectService;

    @GetMapping(SportsProfile.Uri.SPORTS_PROFILE)
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

    @PostMapping(value = SportsProfile.Uri.POLAR_AUTH_PAGE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView submitPolarAuthorizationData(@Valid @ModelAttribute(SportsProfile.Model.POLAR_AUTH) final PolarAuthPageModel request,
                                                     final BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            final ModelAndView modelAndView = new ModelAndView(SportsProfile.View.POLAR_AUTH);
            modelAndView.addObject(SportsProfile.Model.POLAR_AUTH, request);
            return modelAndView;
        }
        return new ModelAndView(redirectService.redirectToPolar(SportsProfile.Uri.POLAR_OAUTH_LINK, request.getClientId()));
    }

    @GetMapping
    public String receiveResponse(@RequestParam("code") String tokenCode) {
        final TokenResponse token = polarClient.getToken(tokenCode, CLIENT_ID, SECRET);
        final SavePolarTokenCommand command = mappingService.map(token);
        commandService.savePolarToken(command);
        return tokenCode + token;
    }

}
