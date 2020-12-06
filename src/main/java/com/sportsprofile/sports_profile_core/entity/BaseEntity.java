package com.sportsprofile.sports_profile_core.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Version
    @Column
    private Long entityVersion;

    @Column(nullable = false)
    private LocalDateTime createdDate;

}

