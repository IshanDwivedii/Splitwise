package com.ishan.expensemgmt;

import com.ishan.expensemgmt.model.Expense;
import com.ishan.expensemgmt.model.Group;
import com.ishan.expensemgmt.model.Transaction;
import com.ishan.expensemgmt.repositories.ExpenseRepository;
import com.ishan.expensemgmt.repositories.GroupRepository;
import com.ishan.expensemgmt.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SettleUpService {

    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    SettleUpService(
            GroupRepository groupRepository,
            ExpenseRepository expenseRepository,
            SettleUpStrategy settleUpStrategy
    )
    {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(
            // 1. check if user exist - to check this create a repository
            // 2. corresponding to user get all user expense
            // 3. for all the user expense get the expense details
            // 4. use ur algo on these expenses to settle up ur user
            // 5. once u get the transactions, then u can filter them acc to ur user
            Long userId
    ){
        //git config --global --unset-all user.email ssh-keygen -t ed25519 -C "dwivediishan75@gmail.com"
        //git config --global user.email "dwivediishan75@gmail.com"
        return null;
    }

    public List<Transaction> settleUpGroup(

            Long groupId
    ){
        //1. check if group exist or not
//        //This prevents NullPointerException (NPE) by forcing the caller
//        to explicitly handle cases where the group is not found.
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        if(groupOpt.isEmpty()){
            throw new RuntimeException("Group not found");
        }
        //if grp exist, get the group
        Group grp = groupOpt.get();
        //using grp we need expense - for this we need expense repository to fetch data from db
        //2. if yes, get all expenses of the group
        List<Expense> expense = expenseRepository.findAllByGroup(grp);

        //3. use the algo to find the function


        //4. return transactions
        return settleUpStrategy.settleUp(expense);
    }
}
// ex: a: 250, b: 250, c=-500
//expense 1
// user exp : user a, amt 250
// user exp : user b, amt 250
// user exp : user c, amt -500