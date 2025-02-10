package com.ishan.expensemgmt.strategies;

import com.ishan.expensemgmt.model.Expense;
import com.ishan.expensemgmt.model.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
