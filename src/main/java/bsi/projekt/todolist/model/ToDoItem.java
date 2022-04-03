package bsi.projekt.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Document
@AllArgsConstructor
public class ToDoItem {

    @Id
    private String id;

    private String text;
    private boolean done;
    private LocalDateTime createdDate;
}
