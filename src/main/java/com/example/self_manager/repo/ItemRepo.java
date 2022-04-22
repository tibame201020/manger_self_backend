package com.example.self_manager.repo;

import com.example.self_manager.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findByCategoryAndSubAndDateBetweenOrderByDateDesc(String category, String sub, String start, String end);

}
