package bsi.projekt.todolist.service;

import bsi.projekt.todolist.model.TodoItemPostgres;
import bsi.projekt.todolist.repository.TodoItemOracleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.execon.fsp.core.FilterInfo;
import pl.execon.fsp.core.FspRequest;
import pl.execon.fsp.core.FspResponse;
import pl.execon.fsp.core.Operation;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class OracleTodoService {


    private TodoItemOracleRepository repository;


    public FspResponse<TodoItemPostgres> get() {
        FspRequest request = FspRequest.builder()
                .filter(Arrays.asList(new FilterInfo("text", Operation.EQUALS, "abc")))
                .build();
        return repository.findFsp(request);
    }

    public FspResponse<TodoItemPostgres> getOracle(FspRequest fspRequest) {
        return repository.findFsp(fspRequest);
    }
}
