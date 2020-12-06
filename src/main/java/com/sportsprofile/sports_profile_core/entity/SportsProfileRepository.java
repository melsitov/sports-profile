package com.sportsprofile.sports_profile_core.entity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsProfileRepository extends PagingAndSortingRepository<SportsProfileEntity, Long>, JpaSpecificationExecutor<SportsProfileEntity> {

    Optional<SportsProfileEntity> findById(String id);
}
