package com.example.space.model.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "space")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"name"})
public class Space extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "space_sequence_generator")
    @TableGenerator(
            name = "space_sequence_generator",
            table = "table_sequences",
            pkColumnValue = "space_sequence" , allocationSize = 1)
    private Long id;

    private String name;


    @Builder
    public Space(Long id , String name){
        this.id = id;
        this.name = name;
    }







}
