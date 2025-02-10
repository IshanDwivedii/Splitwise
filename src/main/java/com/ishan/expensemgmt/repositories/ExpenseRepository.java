package com.ishan.expensemgmt.repositories;

import com.ishan.expensemgmt.model.Expense;
import com.ishan.expensemgmt.model.Group;
import jdk.nio.zipfs.ZipFileAttributeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    List<Expense> findAllGroup(Group group);

    List<Expense> findAllByGroup(Group group);
}
    // select * from expenses where group_id = "xxx"
