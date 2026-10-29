package fonik.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to represent a user.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;


    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Vocabulary> vocabulary = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param email the email
     */
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    /**
     * Adds a vocabulary entry to this user.
     *
     * @param vocabularyEntry vocabulary entry to add
     */
    public void addVocabulary(Vocabulary vocabularyEntry) {
        vocabulary.add(vocabularyEntry);
        vocabularyEntry.setUser(this);
    }

    /**
     * Removes a vocabulary entry from this user.
     *
     * @param vocabularyEntry vocabulary entry to remove
     */
    public void removeVocabulary(Vocabulary vocabularyEntry) {
        vocabulary.remove(vocabularyEntry);
        vocabularyEntry.setUser(null);
    }

    /**
     * Gets vocabulary entries.
     *
     * @return vocabulary entries
     */
    public List<Vocabulary> getVocabulary() {
        return vocabulary;
    }

    /**
     * Sets vocabulary entries.
     *
     * @param vocabulary vocabulary entries
     */
    public void setVocabulary(List<Vocabulary> vocabulary) {
        this.vocabulary = vocabulary;
    }

    /**
     * Gets username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

}