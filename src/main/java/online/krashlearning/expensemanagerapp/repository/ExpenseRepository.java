package online.krashlearning.expensemanagerapp.repository;

import online.krashlearning.expensemanagerapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
