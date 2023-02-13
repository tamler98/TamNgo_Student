package com.spring.studentmanager.repository;

import com.spring.studentmanager.entity.ClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<ClassEntity, Integer> {
}
