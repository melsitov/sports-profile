package com.sportsprofile.sports_profile_core.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sportsprofile.sports_profile_core.entity.PolarTokenEntity;
import com.sportsprofile.sports_profile_core.entity.PolarTokenRepository;
import com.sportsprofile.sports_profile_core.entity.SportsProfileEntity;
import com.sportsprofile.sports_profile_core.entity.SportsProfileRepository;
import com.sportsprofile.sports_profile_ui.service.commands.SavePolarTokenCommand;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SportsProfileCoreCommandServiceImpl implements SportsProfileCoreCommandService {

    @Autowired
    private PolarTokenRepository repository;

    @Autowired
    private SportsProfileRepository sportsProfileRepository;

    @Override
    public void savePolarToken(SavePolarTokenCommand command) {
        final PolarTokenEntity polarTokenEntity = new PolarTokenEntity();
        polarTokenEntity.setAccessToken(command.getAccessToken());
        polarTokenEntity.setTokenType(command.getTokenType());
        polarTokenEntity.setExpiresIn(command.getExpiresIn());
        polarTokenEntity.setXUserId(command.getXUserId());
//        polarTokenEntity.setCreatedAt(LocalDate.now());
        repository.save(polarTokenEntity);
        log.info("New Polar token saved with id: " + polarTokenEntity.getId());
    }
}
