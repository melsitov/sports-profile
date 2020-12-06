package com.sportsprofile.polar_api.client;

import java.util.Base64;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.sportsprofile.polar_api.entity.TokenResponse;
import com.sportsprofile.polar_api.settings.Polar;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PolarClient {

    private final RestTemplate restTemplate;

    public TokenResponse getToken(final String accessCode, final String clientId, final String secret) {

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBasicAuth(encodeClientIdAndSecret(clientId, secret));

        var form = new LinkedMultiValueMap<String, String>();
        form.add("grant_type", "authorization_code");
        form.add("code", accessCode);

        var request = new HttpEntity<MultiValueMap<String, String>>(form, headers);

        ResponseEntity<TokenResponse> responseEntity = restTemplate.postForEntity(Polar.Uri.AUTH_TOKEN_ENDPOINT_URL, request, TokenResponse.class);
        TokenResponse tokenResponse = responseEntity.getBody();
        if (tokenResponse != null) {
            tokenResponse
                    .setSuccess(responseEntity.getStatusCodeValue() == 200);
        }
        return tokenResponse;
    }

    private static String encodeClientIdAndSecret(String clientId, String clientSecret) {
        String encoded = Base64.getEncoder().encodeToString(
                String.format("%s:%s", clientId, clientSecret).getBytes()
        );
        return encoded;
    }
}
