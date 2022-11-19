package com.mustafabas.springProjesi.Entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Students")
@Table
public class Student {
    @Id//id primery key olamsını sağlıyor
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id nin otomatik artmasını sağlıyor
    private Integer id;

    //Öğrenci classının özelikleri
    private String name;
    private String surname;
    private Integer mark;
    private Integer grade;
    private String section;
}
