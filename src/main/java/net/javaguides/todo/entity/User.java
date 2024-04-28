package net.javaguides.todo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// User entity for the db to remember whether valid person is accessing the db or not.
    private Long id;
    private String name;
    @Column(nullable = false, unique =true)

    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
    private List<Role> roles;



}

