package com.example.bankomat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
/**
 * Problem:
 * If you work with inheritances on Mapstruck,
 * PARENT CLASS' fields in the child class will not be generated.
 *
 * Solution:  The solution is @SuperBuilder.
 *
 * Why ?:
 * This is because MapStruct also supports mapping of immutable types via builders.
 * When performing a mapping MapStruct checks if there is a builder for the type being mapped.
 * This is done via the BuilderProvider SPI. If a Builder exists for a certain type,
 * then that builder will be used for the mappings.
 *
 * From: https://mapstruct.org/documentation/stable/reference/html/#mapping-with-builders
 *
 * How to use:
 * Put the annotation on both superclass and subclass,
 * and parent's as well as  child's DTO CLASSES.
 */
public class AbsNameDto {
    private Long id;
    private String name;
    private boolean active;
}
