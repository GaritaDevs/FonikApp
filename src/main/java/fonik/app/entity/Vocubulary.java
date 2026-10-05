package fonik.app.entity;

public class Vocubulary {

    private int id;
    private String germanWord;
    private String englishMeaning;
    private String article;
    private String plural;

    public Vocubulary() {
    }

    public Vocubulary(String germanWord, String englishMeaning, String article, String plural) {
        this.germanWord = germanWord;
        this.englishMeaning = englishMeaning;
        this.article = article;
        this.plural = plural;
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

    @Override
    public String toString() {
        return "Vocubulary{" +
                "id=" + id +
                ", germanWord='" + germanWord + '\'' +
                ", englishMeaning='" + englishMeaning + '\'' +
                ", article='" + article + '\'' +
                ", plural='" + plural + '\'' +
                '}';
    }
}
