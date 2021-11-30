package problems.unruly;
import problems.statespace.Operator;
import problems.statespace.OperatorNotAllowedException;
import problems.statespace.State;

public class PutWhite extends Operator {

    int i;
    int j;

    public PutWhite(int i, int j) {
        this.i = i;
        this.j = j;
    }


    @Override
    public boolean applicable(State st) throws OperatorNotAllowedException {
        int count = 0;
        for (Operator op : State.getOperators()){
            if (op.isFix(st)){
                count++;
            }
        }
        if (count > 0 && !this.isFix(st)){
            return false;
        }
        if (count > 0 && this.isFix(st)){
            return true;
        }
        else {
            if (st instanceof UnrulyState){
                UnrulyState us = (UnrulyState)st;
                if (us.t[i][j] != 0){
                    return false;
                }
                int whiteDbH = 0;
                int whiteDbV = 0;
                for (int k = 0; k < 8; k++){
                    if (us.t[i][k] == 2){
                        whiteDbH++;
                    }
                    if (us.t[k][j] == 2){
                        whiteDbV++;
                    }
                }
                if ((whiteDbH == 4 || whiteDbV == 4) && us.t[i][j] == 0){
                    return false;
                }
                if (i > 1 && us.t[i-1][j] == 2 && us.t[i-2][j] == 2){
                    return false;
                }
                if (i < 6 && us.t[i+1][j] == 2 && us.t[i+2][j] == 2){
                    return false;
                }
                if (j > 1 && us.t[i][j-1] == 2 && us.t[i][j-2] == 2){
                    return false;
                }
                if (j < 6 && us.t[i][j+1] == 2 && us.t[i][j+2] == 2){
                    return false;
                }
                if (i > 0 && i < 7 && us.t[i-1][j] == 2 && us.t[i+1][j] == 2){
                    return false;
                }
                if (j > 0 && j < 7 && us.t[i][j-1] == 2 && us.t[i][j+1] == 2){
                    return false;
                }
                return true;
            }
            throw new OperatorNotAllowedException(this);
        }
    }

    public boolean isFix(State st) throws OperatorNotAllowedException{
        if (st instanceof UnrulyState){
            UnrulyState us = (UnrulyState)st;
            int blackDbH = 0;
            int blackDbV = 0;
            int whiteDbH = 0;
            int whiteDbV = 0;
            for (int k = 0; k < 8; k++){
                if (us.t[i][k] == 1){
                    blackDbH++;
                }
                if (us.t[k][j] == 1){
                    blackDbV++;
                }
                if (us.t[i][k] == 2){
                    whiteDbH++;
                }
                if (us.t[k][j] == 2){
                    whiteDbV++;
                }
            }
            if ((blackDbH == 4 || blackDbV == 4) && (whiteDbH < 4 && whiteDbV < 4) && us.t[i][j] == 0){
                return true;
            }
            if (i > 1 && us.t[i-1][j] == 1 && us.t[i-2][j] == 1 && us.t[i][j] == 0){
                return true;
            }
            if (i < 6 && us.t[i+1][j] == 1 && us.t[i+2][j] == 1 && us.t[i][j] == 0){
                return true;
            }
            if (j > 1 && us.t[i][j-1] == 1 && us.t[i][j-2] == 1 && us.t[i][j] == 0){
                return true;
            }
            if (j < 6 && us.t[i][j+1] == 1 && us.t[i][j+2] == 1 && us.t[i][j] == 0){
                return true;
            }
            if (i > 0 && i < 7 && us.t[i-1][j] == 1 && us.t[i+1][j] == 1 && us.t[i][j] == 0){
                return true;
            }
            if (j > 0 && j < 7 && us.t[i][j-1] == 1 && us.t[i][j+1] == 1 && us.t[i][j] == 0){
                return true;
            }
            return false;
        }
        throw new OperatorNotAllowedException(this);
    }

    @Override
    public State apply(State st) throws OperatorNotAllowedException {
        if (st instanceof UnrulyState){
            UnrulyState us = new UnrulyState((UnrulyState) st);
            us.t[i][j] = 2;
            return us;
        }
        throw new OperatorNotAllowedException(this);
    }

    @Override
    public String toString() {
        return "PutWhite{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
