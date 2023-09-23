package online.krashlearning.expensemanagerapp.service;

import lombok.RequiredArgsConstructor;
import online.krashlearning.expensemanagerapp.dto.ExpenseDTO;
import online.krashlearning.expensemanagerapp.entity.Expense;
import online.krashlearning.expensemanagerapp.repository.ExpenseRepository;
import online.krashlearning.expensemanagerapp.util.DateTimeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    public List<ExpenseDTO> getAllExpenses(){
       List<Expense> list = expenseRepository.findAll();
       List<ExpenseDTO> expenseList = list.stream().map(this::mapToDTO).collect(Collectors.toList());
       return expenseList;
    }

    private ExpenseDTO mapToDTO(Expense expense){
        ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
        expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
        return expenseDTO;
        /**ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setExpenseId(expense.getExpenseId());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setName(expense.getName());
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setDate(expense.getDate());
        return expenseDTO;**/
    }
}
