package br.com.codenation.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import br.com.codenation.domain.PlayersCollection;

public class TeamRepository {
  Map<Long, Team> teams = new HashMap<>();
  Map<Long, Player> players = new HashMap<>();
  Map<Long, List<Long>> playersByTeam = new HashMap<>();
  Map<Long, Long> captainsByTeam = new HashMap<>();

  public void addTeam(Team team) {
    teams.put(team.getId(), team);
    Player captain = team.getCaptain();
    if (captain != null)
      captainsByTeam.put(team.getId(), captain.getId());
  }

  public void addPlayer(Player player) {
    players.put(player.getId(), player);
    List<Long> players = playersByTeam.get(player.getTeamId());
    if (players == null) {
      players = new ArrayList<>();
    }
    players.add(player.getId());
    playersByTeam.put(player.getTeamId(), players);
  }

  public Player findPlayer(Long id) {
    return players.get(id);
  }

  public Team findTeam(Long id) {
    return teams.get(id);
  }

  public PlayersCollection retrieveAllPlayers() {
    return new PlayersCollection(players.values().stream());
  }

  public TeamsCollection retrieveAllTeams() {
    return new TeamsCollection(teams.values().stream());
  }

  public PlayersCollection findPlayersByTeam(Long teamId) {
    return new PlayersCollection(playersByTeam.get(teamId).stream().map(id -> players.get(id)));
  }

  public void updateTeam(Team team) {
    this.addTeam(team);
  }
}