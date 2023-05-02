package com.bjpowernode.pojo;

import lombok.*;

import java.io.Serializable;



@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
