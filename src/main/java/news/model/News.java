package news.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {

    public News() {}

    public News(String title, String description, String text, Date date, boolean active,
                String category, String city, String pathToPicture) {
        this.title = title;
        this.description = description;
        this.text = text;
        this.date = date;
        this.active = active;
        this.category = category;
        this.city = city;
        this.pathToPicture = pathToPicture;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private String text;

    private Date date;

    private boolean active;

    private String category;

    private String city;

    private String pathToPicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categorty) {
        this.category = categorty;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPathToPicture() { return pathToPicture; }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }
}
