package fonik.app.entity;

import javax.persistence.*;

/**
 * A class to represent a German vocabulary entry.
 */
@Entity
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "german_word", nullable = false)
    private String germanWord;

    @Column(name = "english_meaning", nullable = false)
    private String englishMeaning;

    @Column(name = "article")
    private String article;

    @Column(name = "plural")
    private String plural;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Instantiates a new Vocabulary.
     */
    public Vocabulary() {
    }

    /**
     * Instantiates a new Vocabulary.
     *
     * @param germanWord German word
     * @param englishMeaning English meaning
     * @param article German article
     * @param plural plural form
     * @param user owner of vocabulary entry
     */
    public Vocabulary(String germanWord,
                      String englishMeaning,
                      String article,
                      String plural,
                      User user) {

        this.germanWord = germanWord;
        this.englishMeaning = englishMeaning;
        this.article = article;
        this.plural = plural;
        this.user = user;
    }

    public Vocabulary(String baum, String tree, String der, String bäume, String germanWord) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGermanWord() {
        return germanWord;
    }

    public void setGermanWord(String germanWord) {
        this.germanWord = germanWord;
    }

    public String getEnglishMeaning() {
        return englishMeaning;
    }

    public void setEnglishMeaning(String englishMeaning) {
        this.englishMeaning = englishMeaning;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", germanWord='" + germanWord + '\'' +
                ", englishMeaning='" + englishMeaning + '\'' +
                ", article='" + article + '\'' +
                ", plural='" + plural + '\'' +
                '}';
    }
}