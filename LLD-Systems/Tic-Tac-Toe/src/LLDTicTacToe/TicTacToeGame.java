package LLDTicTacToe;



import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//import com.sun.tools.javac.util.Pair

import Model.Board;
import Model.PieceType;
import Model.Player;
import Model.PlayingPieceO;
import Model.PlayingPieceX;
public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;
    int[]rowsum;
    int []colsum;
    int diagsum;
    int antidiagsum;
    static final int N=3; 
    public void initializeGame(){

        //creating 2 Players
       players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        gameBoard = new Board(N);
        
        //add 1 for player1 and -1 for player2
        rowsum=new int[N];
        colsum=new int[N];
        diagsum=0;
        antidiagsum=0;
    }

    public String startGame(){

        boolean noWinner = true;
        int chance=1;//for player 1 chance =1 and for player 2 chance =-1 
        Scanner inputScanner = new Scanner(System.in);
        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            List<int[]> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                inputScanner.close();
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                
                
                continue;
            }
            if(chance==1)
            {
            	rowsum[inputRow]++;
            	colsum[inputColumn]++;
            	if(inputRow==inputColumn)
            		diagsum++;
            	if(inputRow+inputColumn==N-1)//generalize for n
            		antidiagsum++;
            	chance=-1;
            }
            else if(chance==-1)
            {
            	rowsum[inputRow]--;
            	colsum[inputColumn]--;
            	if(inputRow==inputColumn)
            		diagsum--;
            	if(inputRow+inputColumn==N-1)//generalize for n
            		antidiagsum--;
            	chance=1;
            }
            players.addLast(playerTurn);
            if(Math.abs(rowsum[inputRow])==N || Math.abs(colsum[inputColumn])==N || Math.abs(diagsum)==N ||Math.abs(antidiagsum)==N)
            	{
            		inputScanner.close();
            		return playerTurn.name;
            	}
//            boolean winner = isThereWinnerBruteforce(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
//            if(winner) {
//                return playerTurn.name;
//            }
            
        }
        
        return "tie";
    }

    public boolean isThereWinnerBruteforce(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
