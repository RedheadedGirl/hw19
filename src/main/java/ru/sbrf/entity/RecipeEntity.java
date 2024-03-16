package ru.sbrf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "recipes")
@Getter
@NoArgsConstructor
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="recipe", fetch = FetchType.EAGER)
    private List<RecipesComponentsEntity> recipeComponents;

    public RecipeEntity(String name) {
        this.name = name;
    }
}
