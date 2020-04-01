import java.util.*;
import java.util.Random;

public class TicTacToe {

    Random rand = new Random();
    String player1Type = "AI";
    String player2Type = "AI";
    int winner = 0;
    public static boolean DR (char[][] board, int winner, char guy, int x, int y){
        int count = 0;
        int w = x;
        int z = y;
        if(w+winner <= board.length+1 && z+winner <= board[0].length+1){
            for(int i = 0; i < winner; i++){
                w++;
                z++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }

        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(w+winner <= board.length+1){
            for(int i = 0; i < winner; i++){
                w++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(z+winner <= board[0].length+1){
            for(int i = 0; i < winner; i++){
                z++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;

        return false;

    }

    public static boolean UR (char[][] board, int winner, char guy, int x, int y){
        int count = 0;
        int w = x;
        int z = y;

        if(w+winner <= board.length+1 && winner-z >= 1){
            for(int i = 0; i < winner; i++){
                w++;
                z--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }

        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(w+winner <= board.length+1){
            for(int i = 0; i < winner; i++){
                w++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;

        if(winner-z >= 1){
            for(int i = 0; i < winner; i++){
                z--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }

        if(count == winner){
            return true;
        }
        count = 0;

        return false;

    }

    public static boolean DL (char[][] board, int winner, char guy, int x, int y){
        int count = 0;
        int w = x;
        int z = y;
        if(winner-w >= 1 && z+winner <= board[0].length+1){
            for(int i = 0; i < winner; i++){
                w--;
                z++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }

        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(winner-w >= 1){
            for(int i = 0; i < winner; i++){
                w--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(z+winner <= board[0].length+1){
            for(int i = 0; i < winner; i++){
                z++;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;

        return false;

    }

    public static boolean UL (char[][] board, int winner, char guy, int x, int y){
        int count = 0;
        int w = x;
        int z = y;
        if(winner-z >= 1 && winner-w >= 1){
            for(int i = 0; i < winner; i++){
                w--;
                z--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }

        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(winner-w >= 1){
            for(int i = 0; i < winner; i++){
                w--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        if(winner-z >= 1){
            for(int i = 0; i < winner; i++){
                z--;
                if(board[w][z] == guy){
                    count++;
                }
            }
        }


        if(count == winner){
            return true;
        }
        count = 0;
        w = x;
        z = y;

        return false;

    }
    public static int winState(char[][] board, int winner){
        int countx = 0;
        int counto = 0;
        boolean xwon = false;
        boolean owon = false;
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(board[x][y] == 'X'){
                    countx++;
                }
                if(board[x][y] == 'O'){
                    counto++;
                }
            }
        }
        if(countx+counto == board.length+1*board[0].length){
            return 2;
        }
        if(countx > counto && countx >= winner){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'X'){
                        xwon = UL(board, winner, 'X', i, j);
                        if(!xwon){
                            xwon = UR(board, winner, 'X', i, j);
                        }
                        if(!xwon){
                            xwon = DL(board, winner, 'X', i, j);
                        }
                        if(!xwon){
                            xwon = DR(board, winner, 'X', i, j);
                        }

                    }
                }
            }
        }
        if(countx == counto && counto >= winner){
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'X'){
                        owon = UL(board, winner, 'X', i, j);
                        if(!owon){
                            owon = UR(board, winner, 'X', i, j);
                        }
                        if(!owon){
                            owon = DL(board, winner, 'X', i, j);
                        }
                        if(!owon){
                            owon = DR(board, winner, 'X', i, j);
                        }

                    }
                }
            }
        }
        if(xwon){
            return 1;
        } else if(owon){
            return -1;
        } else {
            return 0;
        }
    }

    public void initializeBoard(){
        int boardSize = 0;
        int n = rand.nextInt(4);
        if(n == 0){
            boardSize = 3;
            winner = 3;
        } else if(n == 1){
            boardSize = 5;
            winner = 4;
        } else if(n == 2){
            boardSize = 7;
            winner = 4;
        } else if(n == 3){
            boardSize = 10;
            winner = 5;
        }

        char[][] board = new char[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++){
            for(int j = 0; i < boardSize; i++){
                board[i][j] = 'E';
            }
        }

    }



    public static class decisionTreenode3{
        char[][] board;
        int numKids;
        /*
        int prevColumn = 0;
        int prevRow = 0;
        int UtilityValue = 0;
        */
        char prevMove;
        boolean isLeaf;
        decisionTreenode3[] children;
        decisionTreenode3 parent;


    }

    public static int emptySquares(decisionTreenode3 node){
        int x = 0;
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                if(node.board[j][i] == 'E'){
                    x++;
                }
            }
        }
        return x;
    }
    public decisionTreenode3 getParent(decisionTreenode3 node){
        return node.parent;
    }

    public static void makeChildren3(decisionTreenode3 node){

        while(node.isLeaf == false){

            if (node.prevMove == 'O'){
                for(int i = 0; i < node.children.length; i++){
                    node.children[i].prevMove = 'X';
                    node.children[i].numKids = node.numKids;
                    node.children[i].parent = node;
                    boolean complete = false;
                    for(int m = 0; m < 3; m++){
                        for(int n = 0; n < 3; n++){
                            if(node.children[i].board[m][n] == 'E'){
                                node.children[i].board[m][n] = 'X';
                                complete = true;
                                break;
                            }
                        }
                        if(complete){
                            break;
                        }
                    }
                }
            } else if (node.prevMove == 'X'){
                for(int i = 0; i < node.children.length; i++){
                    node.children[i].prevMove = 'O';
                    node.children[i].numKids = node.numKids;
                    node.children[i].parent = node;
                    boolean complete = false;
                    for(int m = 0; m < 3; m++){
                        for(int n = 0; n < 3; n++){
                            if(node.children[i].board[m][n] == 'E'){
                                node.children[i].board[m][n] = 'O';
                                complete = true;
                                break;
                            }
                        }
                        if(complete){
                            break;
                        }
                    }

                }
            }
            for(int k = 0; k < node.children.length; k++){
                makeChildren3(node.children[k]);
            }
        }
    }

    public class decisionTree3{
        decisionTreenode3 node;
        decisionTreenode3 refNode;
        int PC = node.numKids;
        public decisionTree3(){

            makeChildren3(node);
        }
    }

    public static void main(String[] args){
        decisionTreenode3 node;
        node.board[1][1] = 'X';

    }




}
