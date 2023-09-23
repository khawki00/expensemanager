package online.krashlearning.expensemanagerapp.controller;

import lombok.RequiredArgsConstructor;
import online.krashlearning.expensemanagerapp.dto.ExpenseDTO;
import online.krashlearning.expensemanagerapp.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    @GetMapping("/expenses")
    public String showExpenseList(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenses-list";
    }
}
