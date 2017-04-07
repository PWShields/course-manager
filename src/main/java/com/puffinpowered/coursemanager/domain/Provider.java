package com.puffinpowered.coursemanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by pshields on 7/04/2017.
 */
@Data
@Entity
public class Provider {
    private @Id
    @GeneratedValue
    Long id;

    private String providerName;

    public Provider(String providerName) {
        this.providerName = providerName;
    }

    public Provider() {
    }
}
