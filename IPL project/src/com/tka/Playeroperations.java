
package com.tka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playeroperations {

    Scanner sc = new Scanner(System.in);

    
    private List<Player> getPlayers(String sql, Object... values) {

        List<Player> list = new ArrayList<>();

        try (Connection con = MyDbconfig.getsSQLconnection()) {

            if (con == null) {
                return list;
            }

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                for (int i = 0; i < values.length; i++) {
                    ps.setObject(i + 1, values[i]);
                }

                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {

                        Player p = new Player(
                                rs.getInt("playerid"),
                                rs.getString("name"),
                                rs.getString("teamname"),
                                rs.getInt("runs"),
                                rs.getInt("catches"),
                                rs.getInt("wicket"),
                                rs.getString("category")
                        );

                        list.add(p);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Player> getAllPlayers() {
        return getPlayers("SELECT * FROM players");
    }

    
    public List<Player> getAllPlayersGivenTeamName() {

        System.out.println("Enter Team Name:");
        String team = sc.nextLine();

        return getPlayers(
                "SELECT * FROM players WHERE teamname = ?", team);
    }



    public List<Player> getAllPlayersByCategory() {
        return getPlayers(
                "SELECT * FROM players WHERE category = ?", "Batter");
    }

   
    public List<Player> getAllBowlers() {
        return getPlayers(
                "SELECT * FROM players WHERE category = ?", "Bowler");
    }

    
    public List<Player> getAllAllRounders() {
        return getPlayers(
                "SELECT * FROM players WHERE category = ?", "All-Rounder");
    }

    
    public List<Player> getPlayerById(int id) {
        return getPlayers(
                "SELECT * FROM players WHERE playerid = ?", id);
    }

    
    public List<Player> getPlayerByName(String name) {
        return getPlayers(
                "SELECT * FROM players WHERE name LIKE ?",
                "%" + name + "%");
    }

    
    public List<Player> getPlayersAboveRuns(int runs) {
        return getPlayers(
                "SELECT * FROM players WHERE runs > ?", runs);
    }

    public List<Player> getPlayersAboveWickets(int wickets) {
        return getPlayers(
                "SELECT * FROM players WHERE wicket > ?", wickets);
    }

   
    public List<Player> getPlayersAboveCatches(int catches) {
        return getPlayers(
                "SELECT * FROM players WHERE catches > ?", catches);
    }

    
    public List<Player> getHighestRuns() {
        return getPlayers(
                "SELECT * FROM players WHERE runs = " +
                "(SELECT MAX(runs) FROM players)");
    }

    
    public List<Player> getHighestWickets() {
        return getPlayers(
                "SELECT * FROM players WHERE wicket = " +
                "(SELECT MAX(wicket) FROM players)");
    }

    
    public List<Player> getHighestCatches() {
        return getPlayers(
                "SELECT * FROM players WHERE catches = " +
                "(SELECT MAX(catches) FROM players)");
    }

    
    public List<Player> sortByRuns() {
        return getPlayers(
                "SELECT * FROM players ORDER BY runs DESC");
    }

   
    public List<Player> sortByName() {
        return getPlayers(
                "SELECT * FROM players ORDER BY name ASC");
    }

    
    public List<Player> sortByWickets() {
        return getPlayers(
                "SELECT * FROM players ORDER BY wicket DESC");
    }

    
    public List<Player> sortByCatches() {
        return getPlayers(
                "SELECT * FROM players ORDER BY catches DESC");
    }

    
    public List<String> getAllTeams() {

        List<String> teams = new ArrayList<>();

        try (Connection con = MyDbconfig.getsSQLconnection()) {

            if (con == null) {
                return teams;
            }

            String sql = "SELECT team_name FROM teams ORDER BY team_name";

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    teams.add(rs.getString("team_name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }

    
    public int getPlayerCount() {

        try (Connection con = MyDbconfig.getsSQLconnection()) {

            if (con == null) {
                return 0;
            }

            try (PreparedStatement ps =
                    con.prepareStatement("SELECT COUNT(*) FROM players");
                 ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    
    public List<Player> getPlayersByTeam(String team) {
        return getPlayers(
                "SELECT * FROM players WHERE teamname = ?", team);
    }

    
    public List<Player> getPlayersByRunsRange(int min, int max) {
        return getPlayers(
                "SELECT * FROM players WHERE runs BETWEEN ? AND ?",
                min, max);
    }

    
    public List<Player> getPlayersBelowRuns(int runs) {
        return getPlayers(
                "SELECT * FROM players WHERE runs < ?", runs);
    }

    
    public int getTeamPlayerCount(String team) {

        try (Connection con = MyDbconfig.getsSQLconnection()) {

            if (con == null) {
                return 0;
            }

            try (PreparedStatement ps = con.prepareStatement(
                    "SELECT COUNT(*) FROM players WHERE teamname = ?")) {

                ps.setString(1, team);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
