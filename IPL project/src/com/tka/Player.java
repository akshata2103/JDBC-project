
package com.tka;

public class Player {

    private int playerid;
    private String name;
    private String Teamname;
    private int runs;
    private int catches;
    private int wicket;
    private String Category;

    public Player() {
    }

    public Player(int playerid, String name, String teamname,
                  int runs, int catches, int wicket, String category) {

        this.playerid = playerid;
        this.name = name;
        this.Teamname = teamname;
        this.runs = runs;
        this.catches = catches;
        this.wicket = wicket;
        this.Category = category;
    }

    public int getPlayerid() {
        return playerid;
    }

    public String getName() {
        return name;
    }

    public String getTeamname() {
        return Teamname;
    }

    public int getRuns() {
        return runs;
    }

    public int getCatches() {
        return catches;
    }

    public int getWicket() {
        return wicket;
    }

    public String getCategory() {
        return Category;
    }

    @Override
    public String toString() {
        return "Player ID: " + playerid
                + ", Name: " + name
                + ", Team: " + Teamname
                + ", Runs: " + runs
                + ", Catches: " + catches
                + ", Wickets: " + wicket
                + ", Category: " + Category;
    }
}
