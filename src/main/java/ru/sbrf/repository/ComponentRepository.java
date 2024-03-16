package ru.sbrf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.entity.ComponentEntity;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Short> {

}
