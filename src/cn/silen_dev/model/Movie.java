package cn.silen_dev.model;

public class Movie {
    private int id;
    private String title;
    private String image;
    private String director;
    private String actor;
    private String author;
    private String datePublished;
    private String genre;
    private String duration;
    private String description;
    private String type;
    private String country;
    private String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "id="+id+"" +
                "\ntitle="+title+"" +
                "\nimage="+image+"" +
                "\ndirector="+director+"" +
                "\nactor="+actor+"" +
                "\nauthor="+author+"" +
                "\ndatePublished="+datePublished+"" +
                "\ngenre="+genre+"" +
                "\nduration="+duration+"" +
                "\ndescription="+description+"" +
                "\ntype="+type+"" +
                "\ncountry="+country+"" +
                "\nlanguage="+language;
    }
}
