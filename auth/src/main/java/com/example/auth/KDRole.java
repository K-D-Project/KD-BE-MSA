package com.example.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="roles")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class KDRole {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String role_id;
    private String type;
    private String regist_processor_id;
    private LocalDateTime regist_time;
    private LocalDateTime update_time;
    private String        update_processor_id;
}
