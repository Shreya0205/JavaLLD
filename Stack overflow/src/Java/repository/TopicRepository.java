package Java.repository;

import Java.models.Question;
import Java.models.Topic;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TopicRepository {
    private final HashMap<String, Topic> topics = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Topic save(Topic topic) {
        if (topic.getId() == null) {
            topic.setId(idCounter.getAndIncrement());
        }
        topics.put(topic.getName(), topic);
        return topic;
    }

    public Topic findByName(String name) {
        return topics.get(name);
    }

    public Collection<Topic> findAll() {
        return topics.values();
    }

    public void deleteByName(String name) {
        topics.remove(name);
    }

    public boolean existsByName(String name) {
        return topics.containsKey(name);
    }
}
