package com.mustafabas.springProjesi.Service;

import com.mustafabas.springProjesi.Entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    List<Student> getStudents();

    Student getStudents(Integer id);

    Student updateStudents (Integer id,Student student);

    Boolean deleteStudent(Integer id);
}
