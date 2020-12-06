package com.sportsprofile.sports_profile_core.entity;

import java.time.LocalDate;
import java.util.regex.Pattern;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@Table(name = "polar_token", schema = EntitySchema.NAME)
public class PolarTokenEntity{

    @Id
    @Setter(AccessLevel.NONE)
    @SequenceGenerator(name="seq",sequenceName="public.hibernate_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column
    private String accessToken;

    @Column
    private String tokenType;

    @Column
    private String expiresIn;

    @Column
    private String xUserId;

//    @Column
//    private LocalDate createdAt;

}
