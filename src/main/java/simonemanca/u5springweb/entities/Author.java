package simonemanca.u5springweb.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String dateOfBirth;
    private String avatar;
}

