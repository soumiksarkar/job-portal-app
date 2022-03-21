package com.homeassignment.jobportalapp.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @CreationTimestamp
    @Column(name="created_on")
    protected Instant createdOn;

    @UpdateTimestamp
    @Column(name="updated_on")
    protected  Instant updatedOn;
}
