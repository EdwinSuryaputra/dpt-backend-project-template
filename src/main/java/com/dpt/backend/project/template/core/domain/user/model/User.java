package com.dpt.backend.project.template.core.domain.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String created_by;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = false)
    private String updated_by;

    @Column(nullable = false)
    private Date updated_at;

    private String deleted_by; // nullable

    private Date deleted_at; // nullable
}