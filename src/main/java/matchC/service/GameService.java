package matchC.service;

import matchC.service.beans.CricketMatch;

public interface GameService {
    CricketMatch play(String teamA, String teamB, String overs);
}
