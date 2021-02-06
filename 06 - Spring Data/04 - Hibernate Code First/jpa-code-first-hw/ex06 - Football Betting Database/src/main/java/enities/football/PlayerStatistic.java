package enities.football;

import enities.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="player_statistics")
public class PlayerStatistic implements Serializable {
    private Game game;
    private Player player;
    private int scoredGoals;
    private int playerAssists;
    private int playedMinutesDuringGame;
    //(PK = Game + Player)


    public PlayerStatistic() {
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public PlayerStatistic setGame(Game game) {
        this.game = game;
        return this;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public PlayerStatistic setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Column(name="scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public PlayerStatistic setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
        return this;
    }

    @Column(name="player_assists")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public PlayerStatistic setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
        return this;
    }

    @Column(name="played_minutes_during_game")
    public int getPlayedMinutesDuringGame() {
        return playedMinutesDuringGame;
    }

    public PlayerStatistic setPlayedMinutesDuringGame(int playedMinutesDuringGame) {
        this.playedMinutesDuringGame = playedMinutesDuringGame;
        return this;
    }
}
