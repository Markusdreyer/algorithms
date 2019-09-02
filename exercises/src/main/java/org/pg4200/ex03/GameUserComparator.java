package org.pg4200.ex03;

import java.util.Comparator;

public class GameUserComparator implements Comparator<GameUser> {
    @Override
    public int compare(GameUser o1, GameUser o2) {
        if(o1.getPoints() > o2.getPoints()) {
            return -1;
        } else if(o1.getPoints() == o2.getPoints()) {
            return o1.getUserId().compareTo(o2.getUserId());
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
