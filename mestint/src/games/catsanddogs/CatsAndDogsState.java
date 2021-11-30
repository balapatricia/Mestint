package games.catsanddogs;

import games.statespace.Operator;
import games.statespace.State;

import java.util.Arrays;
import java.util.Scanner;

public class CatsAndDogsState extends State {

    static {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                operators.add(new Put(i,j));
            }
        }
    }

    protected char[][] h = new char[8][8];

    public CatsAndDogsState() {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                h[i][j] = '.';
            }
        }
        player = 'A';
    }

    public CatsAndDogsState(char[][] h, char player) {
        this.h = h;
        this.player = player;
    }

    public CatsAndDogsState(CatsAndDogsState cds) {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                h[i][j] = cds.h[i][j];
            }
        }
        this.player = cds.getPlayer();
    }

    @Override
    public boolean endState() {
        for (Operator op : operators){
            if (op.applicable(this)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAWon() {
        return endState() && player == 'B';
    }

    @Override
    public boolean isBWon() {
        return endState() && player == 'A';
    }

    @Override
    public int miniMaxUtility() {
        int countA = 0;
        int countB = 0;
        boolean changed = false;
        if (isAWon()){
            return 100;
        }
        if (isBWon()){
            return -100;
        }
        if (player == 'B'){
            this.changePlayer();
            changed = true;
        }
        if (player == 'A'){
            for (Operator op : operators){
                if (op.applicable(this)){
                    countA++;
                }
            }
        }
        if (changed){
            this.changePlayer();
            changed = false;
        }
        else if (!changed){
            this.changePlayer();
            changed = true;
        }
        if (player == 'B'){
            for (Operator op : operators){
                if (op.applicable(this)){
                    countB++;
                }
            }
        }
        if (changed){
            this.changePlayer();
        }
        return countA - countB;
    }

    @Override
    public Operator readOperator() {
        Scanner sc = new Scanner(System.in);
        Operator op = null;
        while (true){
            System.out.print("Type your step, please: ");
            int i = sc.nextInt();
            int j = sc.nextInt();
            op = new Put(i-1,j-1);
            if (op.applicable(this)){
                break;
            }
            else {
                System.out.println("This operator is not applicable.");
            }
        }
        return op;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++){
            sb.append(i).append(' ');
        }
        sb.append(System.lineSeparator());
        for (int i = 0; i < 8; i++){
            sb.append(i+1).append(' ');
            for (int j = 0; j < 8; j++){
                sb.append(h[i][j]).append(' ');
            }
            sb.append(System.lineSeparator());
        }
        sb.append("The next player is: Player ");
        sb.append(player);
        return sb.toString();
    }

    public char[][] getH() {
        return h;
    }
}
