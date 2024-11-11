package Java.repository;

import Java.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {
    private final HashMap<Integer, User> users = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.getAndIncrement());
        }
        users.put(user.getId(), user);
        return user;
    }

    public User findById(Integer id) {
        return users.get(id);
    }

    public Collection<User> findAll() {
        return users.values();
    }

    public void deleteById(Integer id) {
        users.remove(id);
    }

    public boolean existsById(Integer id) {
        return users.containsKey(id);
    }

}
