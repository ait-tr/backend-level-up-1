package de.ait.models;

import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 10/9/2023
 * Hibernate
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private Long id;

    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Course> courses;
}
