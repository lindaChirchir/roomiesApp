package roomiesApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import roomiesApp.model.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
	Expense findExpenseById(Integer id);
}
