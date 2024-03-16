package ru.sbrf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.entity.RecipeEntity;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Short> {

    List<RecipeEntity> findAllByNameContaining(String recipeName);

    void deleteByName(String recipeName);
}
