package com.project.loteria.interfaces;

import com.project.loteria.entities.Bet;
import com.project.loteria.entities.Contest;

public interface Facade {
    void addBet(Bet bet);
    void addContest(Contest contest);
    int verifyMatch(Bet bet, Contest contest);
    double valueInvestedAll();
}
