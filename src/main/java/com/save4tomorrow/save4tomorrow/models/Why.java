package com.save4tomorrow.save4tomorrow.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "why")
@AllArgsConstructor
@NoArgsConstructor
public class Why {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false,  columnDefinition = "TEXT")
    @Getter
    @Setter
    private String description;

    @ManyToOne
    @Getter
    @Setter
    private User user;
}
