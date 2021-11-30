package problems.unruly;
import problems.statespace.State;
import java.util.Scanner;
import java.util.StringJoiner;

public class UnrulyState extends State {

    static {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j ++){
                operators.add(new PutWhite(i,j));
                operators.add(new PutBlack(i,j));
            }
        }
    }

    int[][] t = new int[8][8];

    public UnrulyState() {
        System.out.println("Give the start state, please!");
        Scanner sc = new Scanner(System.in);
        String[] pos;
        for (int i = 0; i < 8; i++){
            pos = sc.nextLine().split(" ");
            for (int j = 0; j < 8; j++){
                this.t[i][j] = Integer.parseInt(pos[j]);
            }
        }
    }

    public UnrulyState(UnrulyState us) {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                this.t[i][j] = us.t[i][j];
            }
        }
    }

    @Override
    public boolean goal() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (t[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UnrulyState)){
            return false;
        }
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (t[i][j] != ((UnrulyState)obj).t[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++) {
                sj.add(Integer.toString(t[i][j]));
            }
            sb.append(sj.toString()).append(System.getProperty("line.separator"));
            sj = new StringJoiner(" ");
        }
        return sb.toString();
    }
}

//2 2 0 0 0 1 1 0
//2 0 0 1 0 1 0 0
//0 0 0 0 0 0 0 0
//0 2 0 0 0 0 1 0
//0 0 0 0 2 0 1 0
//0 0 0 0 0 0 0 0
//1 0 0 0 2 0 0 1
//0 2 0 0 0 1 0 0

//0 0 1 0 0 1 0 1
//0 2 0 0 0 0 0 0
//0 2 0 0 2 2 0 1
//0 0 2 0 0 0 2 0
//0 1 0 0 0 2 0 0
//0 0 0 0 2 0 0 0
//0 2 0 0 0 0 1 0
//0 0 0 2 0 2 0 2

//1 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 2
//0 0 0 1 0 0 0 0
//0 0 0 0 0 0 0 0
//0 1 0 0 0 0 0 0
//0 0 0 0 0 2 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0

//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0