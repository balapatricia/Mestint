package games.catsanddogs;

import games.statespace.Operator;
import games.statespace.State;

public class Put extends Operator {

    int i;
    int j;

    public Put(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean applicable(State st) {
        if (!(st instanceof CatsAndDogsState)){
            return false;
        }
        CatsAndDogsState cds = (CatsAndDogsState)st;
        if (i < 0 || i > 7 || j < 0 || j > 7){
            return false;
        }
        if (cds.h[i][j] != '.'){
            return false;
        }
        if (cds.getPlayer() == 'A'){
            if (0 < j && cds.h[i][j-1] == 'D'){
                return false;
            }
            if (0 < i && cds.h[i-1][j] == 'D'){
                return false;
            }
            if (j < 7 && cds.h[i][j+1] == 'D'){
                return false;
            }
            if (i < 7 && cds.h[i+1][j] == 'D'){
                return false;
            }
        }
        else if (cds.getPlayer() == 'B'){
            if (0 < j && cds.h[i][j-1] == 'C'){
                return false;
            }
            if (0 < i && cds.h[i-1][j] == 'C'){
                return false;
            }
            if (j < 7 && cds.h[i][j+1] == 'C'){
                return false;
            }
            if (i < 7 && cds.h[i+1][j] == 'C'){
                return false;
            }
        }
        return true;
    }

    @Override
    public State apply(State st) {
        if (!(st instanceof CatsAndDogsState)){
            return null;
        }
        CatsAndDogsState cds = new CatsAndDogsState((CatsAndDogsState)st);
        if (cds.getPlayer() == 'A'){
            cds.h[i][j] = 'C';
        }
        else {
            cds.h[i][j] = 'D';
        }
        cds.changePlayer();
        return cds;
    }

    @Override
    public String toString() {
        return "Put{" +
                "i=" + (i+1) +
                ", j=" + (j+1) +
                '}';
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
