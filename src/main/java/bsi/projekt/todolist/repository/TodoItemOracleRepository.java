package bsi.projekt.todolist.repository;

import bsi.projekt.todolist.model.TodoItemPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.execon.fsp.oracle.OracleFsp;

@Repository
public interface TodoItemOracleRepository extends JpaRepository<TodoItemPostgres, Long>, OracleFsp<TodoItemPostgres> {
}
