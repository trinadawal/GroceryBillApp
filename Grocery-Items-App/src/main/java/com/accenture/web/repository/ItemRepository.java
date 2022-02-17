package com.accenture.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.web.domain.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
