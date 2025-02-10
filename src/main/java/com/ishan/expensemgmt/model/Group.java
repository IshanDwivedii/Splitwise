package com.ishan.expensemgmt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "user_groups")
public class Group extends BaseModel {

    private long groupId;

    private String groupName;

    @ManyToMany
    private List<User> users;

    @ManyToOne
    private User createdBy;

    //mapped by used to not create a new table as the attribute is mapped to groups already
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

}
