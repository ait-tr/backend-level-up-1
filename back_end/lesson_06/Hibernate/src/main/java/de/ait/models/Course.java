package de.ait.models;

import lombok.*;

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
public class Course {

    private Long id;

    private String title;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Lesson> lessons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Student> students;
}
