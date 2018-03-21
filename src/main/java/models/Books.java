package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {
    
    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private Borrowers currentBorrower;

    public Books() {
    }

    public Books(String title, String author, boolean onLoan) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "is_on_loan")
    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @OneToMany(mappedBy = "books")
    public Borrowers getCurrentBorrower() {
        return currentBorrower;
    }

    public void setCurrentBorrower(Borrowers currentBorrower) {
        this.currentBorrower = currentBorrower;
    }
}
