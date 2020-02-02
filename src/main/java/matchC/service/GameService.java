package matchC.service;

import matchC.CricketMatch;

public interface GameService {
    CricketMatch play(String teamA, String teamB, String overs);
}
