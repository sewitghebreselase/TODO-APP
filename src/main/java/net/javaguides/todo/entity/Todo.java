package net.javaguides.todo.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    private boolean completed;


//    public (String title, String description, boolean completed) {
//        this.title = title;
//        this.description = description;
//        this.completed = completed;
//    }
}
