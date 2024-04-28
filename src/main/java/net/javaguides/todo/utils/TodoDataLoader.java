package net.javaguides.todo.utils;

import net.javaguides.todo.entity.Permission;
import net.javaguides.todo.entity.Role;
import net.javaguides.todo.entity.Todo;
import net.javaguides.todo.entity.User;
import net.javaguides.todo.repository.PermissionRepository;
import net.javaguides.todo.repository.RoleRepository;
import net.javaguides.todo.repository.TodoRepository;
import net.javaguides.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TodoDataLoader implements CommandLineRunner {

    private final BCryptPasswordEncoder passwordEncoder;

    UserRepository userRepository;
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    private final TodoRepository todoRepository;

    public TodoDataLoader(UserRepository userRepository,
                                     BCryptPasswordEncoder passwordEncoder,
                                     RoleRepository roleRepository,
                                     PermissionRepository permissionRepository,
                          TodoRepository todoRepository){

        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.roleRepository=roleRepository;
        this.permissionRepository=permissionRepository;
        this.todoRepository=todoRepository;

    }



    @Override
    public void run(String... args) throws Exception {
        loadTodoData();
    }
//
    private void loadTodoData() {
        Permission permission = new Permission();
        permission.setId(null);
        permission.setName("all");
        permissionRepository.save(permission);
            Role role = new Role();
            role.setName("admin");
            role.setId(null);
            role.setPermissions(new ArrayList<>());


            role.getPermissions().add(permission);
            roleRepository.save(role);

             User user= new User();
            user.setEmail("string@email");
            user.setId(null);
            user.setName("sewit");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRoles(new ArrayList<>());
            user.getRoles().add(role);

            userRepository.save(user);

}
}
