package com.spring.studentmanager.repository;

import com.spring.studentmanager.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    List<StudentEntity> findByNameContaining(String searchInput);
}
