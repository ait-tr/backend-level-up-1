package de.ait.models;

import lombok.*;

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
public class Lesson {

    private Long id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Course course;
}
