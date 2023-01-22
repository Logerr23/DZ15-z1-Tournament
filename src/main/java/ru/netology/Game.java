package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> registeredPlayers = new ArrayList<>();

    public List<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register (Player player) {
        registeredPlayers.add(player);
    }

    public Player findByName (String name) {
        for (Player player : registeredPlayers) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round (String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + ", не зарегестрирован.");
        }

        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + ", не зарегестрирован.");
        }

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if(player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }


}
