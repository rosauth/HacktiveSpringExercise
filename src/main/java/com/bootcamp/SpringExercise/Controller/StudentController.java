package com.bootcamp.SpringExercise.Controller;

import com.bootcamp.SpringExercise.Entity.Student;
import com.bootcamp.SpringExercise.Util.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/")
    public String showStudents(@PageableDefault(size = 5) Pageable pageable, Model model){
        Page<Student> studentPage = studentDAO.findAll(pageable);
        model.addAttribute("page", studentPage);

        return "index";
    }

    @GetMapping(path = "/update-data")
    public String updateData(int id, Model model){
        Student student = studentDAO.findById(id).get();

        model.addAttribute("data", student);

        return "editData";
    }

    @PostMapping("/saved/{id}")
    public String insertData(@PathVariable("id") int id, Student studentObj, BindingResult bindingResult, Model model){

        studentDAO.save(studentObj);
        model.addAttribute("page", studentDAO.findAll());
        return "redirect:/";
    }


    /*@PostMapping("/deleted/{id}")
    public String deleteData(@PathVariable("id") int id) {
        studentDAO.deleteById(id);
        return "redirect:/";
    }*/

}
