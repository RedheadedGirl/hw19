package ru.sbrf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "components")
@Getter
@NoArgsConstructor
public class ComponentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "component")
    private String component;

    public ComponentEntity(String component) {
        this.component = component;
    }
}
