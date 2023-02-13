package com.spring.studentmanager.service;

import com.spring.studentmanager.entity.StudentEntity;
import com.spring.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Object findAll() { return studentRepository.findAll();
    }

    public void save(StudentEntity student) { studentRepository.save(student);
    }

    public Object findById(int id) { return studentRepository.findById(id);
    }

    public void deleteById(int id) { studentRepository.deleteById(id);
    }

    public List<StudentEntity> findByNameContaining(String searchInput) { return studentRepository.findByNameContaining(searchInput);
    }
}
