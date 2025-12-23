package ru.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.store.enums.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String name;
    private String lastName;
    private Role userRole;
}
