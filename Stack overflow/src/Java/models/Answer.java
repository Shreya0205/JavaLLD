package Java.models;

public class Answer {
    Integer id;
    String summary;

    public Answer(Integer id, String summary) {
        this.id = id;
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
