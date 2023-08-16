package ru.learnUp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//import javax.persistence.*;

//@Entity
//@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Animal {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column
    private String name;

    public Animal() {

    }
}
