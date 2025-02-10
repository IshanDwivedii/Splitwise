package com.ishan.expensemgmt.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private String password;
    private String phoneNumber;

}
