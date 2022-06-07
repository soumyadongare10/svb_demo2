package com.amiya.springbootdemoproject.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//specifies that the class is an entity and is mapped to a database table.
@Data
// is a convenient shortcut annotation that bundles the features of
// @ToString , @EqualsAndHashCode , @Getter / @Setter
@NoArgsConstructor
// generates a constructor with no parameter
@AllArgsConstructor
// generates a constructor requiring argument for every field in the annotated class
//@Builder

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentEmail;
    private String departmentCode;
}