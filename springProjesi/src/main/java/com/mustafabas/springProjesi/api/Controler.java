package com.mustafabas.springProjesi.api;

import com.mustafabas.springProjesi.Entity.Student;
import com.mustafabas.springProjesi.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//bizim controlerımızın dişarıya api olarak açılması için bu kodu eklemeliyiz
@RequestMapping("/student")
public class Controler {
    private final StudentService studentService;

    public Controler(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")//bu kod dizisinde Tabloya student nesnelerini atıyoruz.tanımlanan url ile ve post işlemiyle
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student student1=studentService.createStudent(student);
        return ResponseEntity.ok(student1);
    }
    @GetMapping("/getAll")//bu kod dizisinde Tablodaki Student verilerinin getirmeyi sağlıyoruz tanımlanan url ile ve get işlemiyle
    public ResponseEntity<List <Student>> getStudents(){
        List<Student> students=studentService.getStudents();
        return ResponseEntity.ok(students);
    }
    @GetMapping("/getById/{id}")//bu kod dizisinde istediğimiz veri id verek ve tanımlanan url ardesi ile ekrana getiriyoruz json verisi olarak
    public ResponseEntity<Student> getStudents(@PathVariable("id") Integer id){
        Student student=studentService.getStudents(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/update/{id}")//bu kod dizisinde istediğimiz veri id vererek tanımlanan url adresi ile istediğimiz student değerini günceliyoruz
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){//web api için RequestBody kullanılır
        Student ResultStudent=studentService.updateStudents(id,student);
        return ResponseEntity.ok(ResultStudent);
    }
    @DeleteMapping("/delete/{Id}")//bu kod dizisinde istediğimiz veri id vererek tanımlanan url adresi ile istediğimiz student değerini siliyoruz
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("Id") Integer id){
        Boolean status=studentService.deleteStudent(id);
        return ResponseEntity.ok(status);
    }
}
