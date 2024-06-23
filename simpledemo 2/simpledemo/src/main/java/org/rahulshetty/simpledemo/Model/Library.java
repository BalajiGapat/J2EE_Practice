package org.rahulshetty.simpledemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name ="BookLibrary")
public class Library {
    @Column(name = "Author")
    private String author;
    @Column(name = "BookName")
    private String book_name;
    @Column(name = "ISBN")
    private String ISBN;
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "Aisle")
    private int aisle;
}
