public class Game {



    Tile[][][] board = new Tile[3][2][2];

    public Tile[][][] getBoard() {
        return board;
    }

    public void initialise() {
        for (int z = 0; z < 3; z++) {
            for (int x = 0; x < 2; x++) {
                for (int y = 0; y < 2; y++) {
                    board[z][x][y] = new Tile(false);
                }
            }
        }
    }

    public void print(){
        for (int z = 0; z < 3;z++) {
            for (int x = 0; x < 2; x++) {
                for (int y = 0; y < 2; y++) {
                    if (board[z][x][y].isOccupied) {
                        System.out.print("[x]");
                    } else System.out.print("[]");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("===========================================");
    }

    public static void main(String[] args){
        Game game = new Game();
        game.initialise();
        game.print();

        Tile[][][] board = game.getBoard();

        Player player = new Player(new Builder());
        player.placeBuilder(board,player.builder,0,0);

        game.print();

        // test move builder north
        try {
            player.moveBuilder(board,player.builder,new Move(0,1));
        } catch (InvalidMoveExcpetion invalidMoveExcpetion) {
            invalidMoveExcpetion.printStackTrace();
        }

        game.print();


    }
}
