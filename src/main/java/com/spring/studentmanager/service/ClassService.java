package com.spring.studentmanager.service;

import com.spring.studentmanager.entity.ClassEntity;
import com.spring.studentmanager.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    public Object findAll() { return classRepository.findAll();
    }
}
