package simonemanca.u5springweb.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    private int id;
    private String title;
    private String content;
    private int authorId;
}

