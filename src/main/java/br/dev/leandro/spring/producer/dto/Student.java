package br.dev.leandro.spring.producer.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Student implements Serializable {

    private static final long serialVersionUID=1L;
    private String studentId;
    private String name;
    private String rollNumber;

}
