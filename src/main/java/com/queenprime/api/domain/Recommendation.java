package com.queenprime.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recommendation {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private Long videoId;
}
