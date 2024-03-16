package ru.sbrf.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sbrf.entity.ComponentEntity;
import ru.sbrf.entity.RecipeEntity;
import ru.sbrf.entity.RecipesComponentsEntity;
import ru.sbrf.repository.ComponentRepository;
import ru.sbrf.repository.RecipeRepository;
import ru.sbrf.repository.RecipesComponentsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CookingBookService {

    private final RecipeRepository recipeRepository;
    private final ComponentRepository componentRepository;
    private final RecipesComponentsRepository recCompRepository;

    public void findRecipeByName(String name) {
        List<RecipeEntity> list = recipeRepository.findAllByNameContaining(name);
        if (list.isEmpty()) {
            System.out.println("No recipes found");
        }
        list.forEach(recipeEntity -> {
            System.out.println("Recipe \"" + recipeEntity.getName() + "\". Components: ");
            recipeEntity.getRecipeComponents().forEach(recComp -> {
                System.out.println(recComp.getComponent().getComponent() + ": " + recComp.getAmount());
            });
        });
    }

    public RecipeEntity saveRecipe(RecipeEntity recipe) {
        return recipeRepository.save(recipe);
    }

    public ComponentEntity saveComponent(ComponentEntity component) {
        return componentRepository.save(component);
    }

    public RecipesComponentsEntity saveRecipeComponent(RecipesComponentsEntity recipesComponents) {
        return recCompRepository.save(recipesComponents);
    }

    @Transactional
    public void deleteRecipe(String name) {
        recipeRepository.deleteByName(name);
    }

}
