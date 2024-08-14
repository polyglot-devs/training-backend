package com.polyglot.training.Repositiory;

import com.polyglot.training.model.Items;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
