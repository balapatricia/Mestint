package games.catsanddogs;

import games.game.Game;
import games.statespace.State;

import java.util.Scanner;

public class CatsAndDogsGame {

    public static void main(String[] args) {
//        char[][] start = new char[8][8];
//        Scanner sc = new Scanner(System.in);
//        int aDb = 0;
//        int bDb = 0;
//        for (int i = 0; i < 8 ; i++){
//            String line = sc.nextLine();
//            for (int j = 0; j < 8; j++){
//                if (line.charAt(j) == 'C'){
//                    aDb++;
//                }
//                else if (line.charAt(j) == 'D'){
//                    bDb++;
//                }
//                start[i][j] = line.charAt(j);
//            }
//        }
//        Game game = new Game(new CatsAndDogsState(start,(aDb < bDb ? 'A' :'B')));
        Game game = new Game(new CatsAndDogsState());
        System.out.println(game);
        game.play();
    }
}


//........
//...C....
//.D......
//........
//....D...
//........
//........
//......C.
