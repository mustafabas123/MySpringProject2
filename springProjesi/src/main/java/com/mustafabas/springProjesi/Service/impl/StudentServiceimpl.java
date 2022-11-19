package com.mustafabas.springProjesi.Service.impl;

import com.mustafabas.springProjesi.Entity.Student;
import com.mustafabas.springProjesi.Repository.StudentRepository;
import com.mustafabas.springProjesi.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudents(Integer id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){//eğer student değişkeni varsa değer dönsün yoksa null dönsün
            return student.get();
        }
        return null;
    }

    @Override
    public Student updateStudents(Integer id, Student student) {
        Optional<Student> resultStudent=studentRepository.findById(id);
        if(resultStudent.isPresent()){
            resultStudent.get().setName(student.getName());
            resultStudent.get().setSurname(student.getSurname());
            resultStudent.get().setMark(student.getMark());
            resultStudent.get().setSection(student.getSection());
            resultStudent.get().setGrade(student.getGrade());
            return studentRepository.save(resultStudent.get());
        }
        return null;
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
