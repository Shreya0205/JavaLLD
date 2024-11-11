package Java.services;

import Java.exceptions.ResourceNotFoundException;
import Java.models.Topic;
import Java.models.User;
import Java.repository.TopicRepository;

public class TopicService {
    private final TopicRepository topicRepository;
    private static TopicService topicService;

    public TopicService(){
        topicRepository = new TopicRepository();
    }

    public static TopicService getInstance() {
        if (topicService == null) {
            topicService = new TopicService();
        }
        return topicService;
    }

    public Topic createTopic(String name){
        Topic topic = new Topic(null, name);
        topicRepository.save(topic);
        return topic;
    }

    public Topic findTopic(String name){
        Topic topic = topicRepository.findByName(name);
        return topic;
    }

}
