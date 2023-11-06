package com.example.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class KDUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String user_id;
    private String name;
    private String email;
    private String regist_processor_id;
    private LocalDateTime regist_time;
    private LocalDateTime update_time;
    private String        update_processor_id;
    private String        password;

    @ManyToMany
    @JoinTable(name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private List<KDRole> roles;

}
