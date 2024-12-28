package Code.models;

import java.util.List;

public class Team {

    Integer id;
    String name;
    List<Player> playerList;

    public Team(Integer id, String name, List<Player> playerList) {
        this.id = id;
        this.name = name;
        this.playerList = playerList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerList=" + playerList.toString() +
                '}';
    }
}
