package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrowers")
public class Borrowers {

    private int id;
    private String name;
    private Set<Books> itemsBorrowed;

    public Borrowers() {
    }

    public Borrowers(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    public Set<Books> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(Set<Books> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }
}
