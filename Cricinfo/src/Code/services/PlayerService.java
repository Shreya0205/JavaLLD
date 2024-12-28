package Code.services;

import Code.models.Player;
import Code.models.PlayerRole;

import java.util.HashMap;

public class PlayerService {
    private static PlayerService instance;
    private HashMap<Integer, Player> players;

    private PlayerService() {
        players = new HashMap<>();
    }

    public static PlayerService getInstance() {
        if (instance == null) {
            instance = new PlayerService();
        }
        return instance;
    }

    public Player createPlayer(Integer id, String name, PlayerRole role) {
        Player player = new Player(id, name, role);
        players.put(id, player);
        return player;
    }

    public Player getPlayerById(Integer id) {
        return this.players.get(id);
    }

}
