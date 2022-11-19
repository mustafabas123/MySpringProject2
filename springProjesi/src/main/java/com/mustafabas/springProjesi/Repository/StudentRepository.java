package com.mustafabas.springProjesi.Repository;

import com.mustafabas.springProjesi.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {//<Class,primeyKey'in tanımlanan yapısı>
}
