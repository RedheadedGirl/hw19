package ru.sbrf.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes_components")
@Getter
@NoArgsConstructor
public class RecipesComponentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @ManyToOne
    @JoinColumn(name="id_recipe", nullable=false)
    private RecipeEntity recipe;

    @ManyToOne
    @JoinColumn(name="id_component", nullable=false)
    private ComponentEntity component;

    @Column(name = "amount")
    private Integer amount;

    public RecipesComponentsEntity(RecipeEntity recipe, ComponentEntity component, Integer amount) {
        this.recipe = recipe;
        this.component = component;
        this.amount = amount;
    }
}
