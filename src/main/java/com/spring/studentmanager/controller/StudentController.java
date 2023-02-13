package com.spring.studentmanager.controller;

import com.spring.studentmanager.entity.ClassEntity;
import com.spring.studentmanager.entity.StudentEntity;
import com.spring.studentmanager.repository.ClassRepository;
import com.spring.studentmanager.service.ClassService;
import com.spring.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping()
    public String showStudent(Model model) {
        List<StudentEntity> studentList = (List<StudentEntity>) studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "homepage";
    }

    @GetMapping(value = "newStudent")
    public String newBook(Model model) {
        model.addAttribute("student", new StudentEntity());
        model.addAttribute("action", "newStudent");
        setDropClassList(model);
        return "student";
    }
    @PostMapping(value = "newStudent")
    public String saveNewBook(@Valid @ModelAttribute(name = "student") StudentEntity student, BindingResult result, Model model) {
        if(result.hasErrors() || student.getClassEntity().getId() == 0) {
            setDropClassList(model);
            if (student.getClassEntity().getId() == 0) {
                model.addAttribute("message", "Please choose class");
            }
            return "student";
        }
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping(value = "edit/{id}")
    public String updateStudent(@PathVariable int id, Model model){
        model.addAttribute("action", "updateStudent");
        model.addAttribute("type", "Update Student");
        model.addAttribute("msg", "Edit student information");
        model.addAttribute("student", studentService.findById(id));

        setDropClassList(model);
        return "student";
    }

    @PostMapping(value = "edit/updateStudent")
    public String saveUpdate(@Valid @ModelAttribute(name="student") StudentEntity student, BindingResult result, Model model) {
        if(result.hasErrors() || student.getClassEntity().getId() == 0) {
            setDropClassList(model);
            model.addAttribute("type", "Update Student");
            if (student.getClassEntity().getId() == 0) {
                model.addAttribute("message", "Please choose class");
            }
            return "student";
        }
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/search")
    public String searchStudent(@RequestParam String searchInput, Model model) {
        List<StudentEntity> studentSearch = studentService.findByNameContaining(searchInput);
        model.addAttribute("studentList", studentSearch);
        return "homepage";
    }
    public void setDropClassList(Model model) {
        List<ClassEntity> classList = (List<ClassEntity>) classService.findAll();
        if(!classList.isEmpty()) {
            Map<Integer, String> class1 = new HashMap<>();
            for (ClassEntity classes: classList) {
                class1.put(classes.getId(), classes.getName());
            }
            model.addAttribute("classList", class1);
        }
    }
}
