package ru.LearnUp.LearnUp24_DATA_JPA.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Getter
@Setter

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String title;

    @Column
    private String text;

//    mappedBy = "post" - имя поля в классе Comment, на которое ссылается эта связь
//    FetchType.EAGER - значит комментарии всегда подтягиваются из базы данных при вызове
//    CascadeType.ALL - значит все комментарии после удаления поста Post удаляются из базы данных
//     и другие каскадные операции (кроме ON UPDATE, как в SQL)
//@OnDelete(action = OnDeleteAction.CASCADE) тоже значит все комментарии после удаления поста Post удаляются из базы данных
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT) //чтобы комментарии вытягивались одним запросом для всех постов сразу
    private List<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                '}';
    }

}
