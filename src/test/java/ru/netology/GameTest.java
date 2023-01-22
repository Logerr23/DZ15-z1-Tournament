package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    Game list = new Game();

    Player player1 = new Player(1,"Logerr23",3);
    Player player2 = new Player(2,"Neekron",8);
    Player player3 = new Player(3,"GreenLeed",7);
    Player player4 = new Player(4,"FadeiIV",11);
    Player player5 = new Player(5,"Pvtgemini",4);
    Player player6 = new Player(6,"Shelma0620",5);
    Player player7 = new Player(7,"Leeroy",11);
    Player player8 = new Player(8,"Mo",9);
    Player player9 = new Player(9,"mrPzd",2);
    Player player10 = new Player(10,"3Hbks",6);

    @BeforeEach
    public void setup() {
        list.register(player1);
        list.register(player2);
        list.register(player3);
        list.register(player4);
        list.register(player5);
        list.register(player6);
        list.register(player7);
        list.register(player8);
        list.register(player9);
        list.register(player10);
    }


    @Test
    public void registeredTest() {

        List<Player> expected = Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);
        List<Player> actual = list.getRegisteredPlayers();

        Assertions.assertEquals(expected, actual);

    }


    @Test
    public void roundTestDraw() {

        int expected = 0;
        int actual = list.round("FadeiIV", "Leeroy");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTestPlayer1Winner() {

        int expected = 1;
        int actual = list.round("Mo", "Shelma0620");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTestPlayer2Winner() {

        int expected = 2;
        int actual = list.round("Logerr23", "3Hbks");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void firstPlayerNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            list.round("Ваня", "3Hbks");
        });
    }

    @Test
    public void theSecondPlayerNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            list.round("3Hbks", "Ваня");
        });
    }

}

