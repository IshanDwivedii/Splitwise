package com.ishan.expensemgmt.strategies;

import com.ishan.expensemgmt.model.Expense;
import com.ishan.expensemgmt.model.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expense);
}
