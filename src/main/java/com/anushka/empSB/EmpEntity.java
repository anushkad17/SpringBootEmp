package com.anushka.empSB;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="Emp_DB")
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto generated
    private int id;
    private String name;
    private int phoneno;
    private String email;
}
