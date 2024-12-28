package Code.models;

public class Player {

    Integer id;
    String name;
    PlayerRole playerRole;

    public Player(Integer id, String name, PlayerRole playerRole) {
        this.id = id;
        this.name = name;
        this.playerRole = playerRole;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerRole getPlayerRole() {
        return playerRole;
    }

}
