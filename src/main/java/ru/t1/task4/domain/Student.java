
package ru.t1.task4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    private Integer testBookNumber;
    private String faculty;
    private String firstName;
    private String lastName;
    private String middleName;
}
