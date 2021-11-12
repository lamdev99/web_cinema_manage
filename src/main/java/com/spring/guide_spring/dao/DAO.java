package com.spring.guide_spring.dao;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T> {
	Optional<T> get(int id);
    Collection<T> getAll();
}
