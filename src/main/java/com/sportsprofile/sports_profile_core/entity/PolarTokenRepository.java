package com.sportsprofile.sports_profile_core.entity;

import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolarTokenRepository extends PagingAndSortingRepository<PolarTokenEntity, Long>, JpaSpecificationExecutor<PolarTokenEntity> {

    Optional<PolarTokenEntity> findByAccessToken(String accessToken);
    Optional<PolarTokenEntity> findSportsProfileEntityByAccessToken (String accessToken);

}
