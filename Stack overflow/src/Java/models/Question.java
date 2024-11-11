package Java.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Question {
    Integer id;
    User user;
    LocalDateTime timestamp;
    String summary;
    ArrayList<Topic> topics;
    ArrayList<Answer> answers;

    public Question(Integer id, User user, String summary, Topic topic) {
        this.id = id;
        this.user = user;
        this.summary = summary;
        this.timestamp = LocalDateTime.now();
        this.topics = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.topics.add(topic);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public boolean isAddedToTopic(Topic topic){
        return this.topics.contains(topic);
    }

    public void addTopic(Topic topic) {
        this.topics.add(topic);
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void addAnswers(Answer answer) {
        this.answers.add(answer);
    }

    @Override
    public String toString() {
        System.out.println("Question ID: " + this.getId());
        System.out.println("Summary : " + summary);
        System.out.print("Topics are: ");
        for(Topic topic: this.topics){
            System.out.print(topic.getName() +", ");
        }
        if(this.answers.size()==0){
            System.out.println("\nNo answers for this question");
        }
        else{
            System.out.println("\nAnswers are: ");
            for(Answer answer: this.answers){
                System.out.println("Answer ID: " + answer.getId() + " summary: " + answer.getSummary());
            }
        }
        System.out.println("________________________________");
        return "";
    }

}
