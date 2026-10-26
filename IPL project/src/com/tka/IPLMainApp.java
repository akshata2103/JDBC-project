
package com.tka;

import java.util.List;

public class IPLMainApp {

    public static void main(String[] args) {

        System.out.println("Welcome to IPL.com");
        Playeroperations playersOps = new Playeroperations();

        System.out.println("\n1. Get All Players All Teams");
        List<Player> allPlayersList = playersOps.getAllPlayers();
        allPlayersList.forEach(System.out::println);

        System.out.println("\n2. Get All Players of Given TeamName");
        List<Player> allPlayersGivenTeamName =
                playersOps.getAllPlayersGivenTeamName();
        allPlayersGivenTeamName.forEach(System.out::println);

        System.out.println("\n3. Get All Batters of All Teams");
        List<Player> allBatters = playersOps.getAllPlayersByCategory();
        allBatters.forEach(System.out::println);

        System.out.println("\n4. Get All Bowlers");
        playersOps.getAllBowlers().forEach(System.out::println);

        System.out.println("\n5. Get All All-Rounders");
        playersOps.getAllAllRounders().forEach(System.out::println);

        System.out.println("\n6. Search Player By ID");
        playersOps.getPlayerById(1).forEach(System.out::println);

        System.out.println("\n7. Search Player By Name");
        playersOps.getPlayerByName("Virat").forEach(System.out::println);

        System.out.println("\n8. Get Players With Runs Above 500");
        playersOps.getPlayersAboveRuns(500).forEach(System.out::println);

        System.out.println("\n9. Get Players With Wickets Above 10");
        playersOps.getPlayersAboveWickets(10).forEach(System.out::println);

        System.out.println("\n10. Get Players With Catches Above 5");
        playersOps.getPlayersAboveCatches(5).forEach(System.out::println);

        System.out.println("\n11. Get Player With Highest Runs");
        playersOps.getHighestRuns().forEach(System.out::println);

        System.out.println("\n12. Get Player With Highest Wickets");
        playersOps.getHighestWickets().forEach(System.out::println);

        System.out.println("\n13. Get Player With Highest Catches");
        playersOps.getHighestCatches().forEach(System.out::println);

        System.out.println("\n14. Sort Players By Runs");
        playersOps.sortByRuns().forEach(System.out::println);

        System.out.println("\n15. Sort Players By Name");
        playersOps.sortByName().forEach(System.out::println);

        System.out.println("\n16. Sort Players By Wickets");
        playersOps.sortByWickets().forEach(System.out::println);

        System.out.println("\n17. Sort Players By Catches");
        playersOps.sortByCatches().forEach(System.out::println);

        System.out.println("\n18. Get All Team Names");
        playersOps.getAllTeams().forEach(System.out::println);

        System.out.println("\n19. Get Total Players");
        System.out.println(playersOps.getPlayerCount());

        System.out.println("\n20. Get Players Of MI");
        playersOps.getPlayersByTeam("MI").forEach(System.out::println);

        System.out.println("\n21. Get Players Of CSK");
        playersOps.getPlayersByTeam("CSK").forEach(System.out::println);

        System.out.println("\n22. Get Players Of RCB");
        playersOps.getPlayersByTeam("RCB").forEach(System.out::println);

        System.out.println("\n23. Get Players With Runs Between 200 And 500");
        playersOps.getPlayersByRunsRange(200, 500)
                .forEach(System.out::println);

        System.out.println("\n24. Get Players With Runs Below 100");
        playersOps.getPlayersBelowRuns(100).forEach(System.out::println);

        System.out.println("\n25. Get Total Players In MI");
        System.out.println(playersOps.getTeamPlayerCount("MI"));
    }
}
