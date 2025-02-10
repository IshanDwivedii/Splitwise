package com.ishan.expensemgmt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Expense expense;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
