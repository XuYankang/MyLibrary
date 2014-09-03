package interview;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by jacob on 14-9-3.
 */
public class VoteSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> votes = new LinkedHashMap<String, Integer>();
        int invalid = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("addCandidate")) {
                String name = line.trim().substring("addCandidate".length() + 1).trim();
                votes.put(name, 0);
            } else if (line.startsWith("vote")) {
                String votedName = line.substring("vote".length() + 1).trim();
                if (votes.containsKey(votedName)) {
                    votes.put(votedName, votes.get(votedName) + 1);
                } else {
                    invalid++;
                }
            } else if (line.startsWith("getVoteResult")) {
                for (String name : votes.keySet()) {
                    System.out.println(name + " " + votes.get(name));
                }
                System.out.println(invalid);
            }

        }
    }
}
