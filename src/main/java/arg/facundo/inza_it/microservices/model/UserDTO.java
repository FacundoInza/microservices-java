package arg.facundo.inza_it.microservices.model;

import lombok.*;
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @ToString.Exclude
    private int age;
}


