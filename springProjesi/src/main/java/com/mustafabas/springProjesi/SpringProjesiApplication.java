package com.mustafabas.springProjesi;

import com.mustafabas.springProjesi.Entity.Student;
import com.mustafabas.springProjesi.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringProjesiApplication implements CommandLineRunner {
	private final StudentRepository studentRepository;//final değşkeni ile tanımlamamızın nedeni dişardan müdahale olmasın

	public SpringProjesiApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProjesiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//program çalıştığında default olarak yani otomatik olarak sanal database bu veriler kaydediliyor
		Student student1=Student.builder().name("Mustafa").surname("Baş").mark(161).grade(12).section("A").build();
		Student student2=Student.builder().name("Beyza").surname("Aydın").mark(150).grade(12).section("A").build();
		Student student3=Student.builder().name("Burak").surname("Kapacak").mark(123).grade(12).section("A").build();
		Student student4=Student.builder().name("Minever").surname("Baş").mark(150).grade(12).section("A").build();
		Student student5=Student.builder().name("Ahmet").surname("Yılmaz").mark(102).grade(12).section("A").build();
		Student student6=Student.builder().name("Arif").surname("Kara").mark(130).grade(12).section("A").build();
		Student student7=Student.builder().name("Merve").surname("Öztekin").mark(176).grade(12).section("A").build();
		studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4,student5,student6,student7));
	}
}
