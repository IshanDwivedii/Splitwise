package com.ishan.expensemgmt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class Expense extends BaseModel{

    private String name;

    private String description;

    private int amount;

    @ManyToOne
    private Group group;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expense;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "expense")
    private List<UserExpense> userExpenses;
//    @ManyToOne
//    private User paidBy;
}
