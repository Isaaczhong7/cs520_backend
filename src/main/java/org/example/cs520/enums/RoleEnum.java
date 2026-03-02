package org.example.cs520.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Xinyuan Xu, Isaac 
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {

    ADMIN(1, "admin", "admin"),
    PROF(2, "professor", "prof"),
    STU(3, "student", "stu");


    private final Integer roleId;

    private final String name;

    private final String label;
}

