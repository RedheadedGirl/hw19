package ru.sbrf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.entity.RecipesComponentsEntity;

@Repository
public interface RecipesComponentsRepository extends JpaRepository<RecipesComponentsEntity, Short> {

}
