// File: ChessPiece.java

import java.util.Scanner;

public class ChessBoard {
    private static final Piece[][] board = new Piece[8][8];

    public static void main(String[] args) {
        initializeBoard();
        Scanner scanner = new Scanner(System.in);
        boolean whiteTurn = true;

        while (true) {
            printBoard();
            System.out.println((whiteTurn ? "White" : "Black") + "'s turn");
            System.out.print("Enter your move (e.g., 'e2 e4'): ");
            String move = scanner.nextLine();
            if (move.equalsIgnoreCase("exit")) break;

            String[] positions = move.split(" ");
            if (positions.length != 2) {
                System.out.println("Invalid move format. Please use 'e2 e4' format.");
                continue;
            }

            int startX = positions[0].charAt(0) - 'a';
            int startY = positions[0].charAt(1) - '1';
            int endX = positions[1].charAt(0) - 'a';
            int endY = positions[1].charAt(1) - '1';

            if (!isValidPosition(startX, startY) || !isValidPosition(endX, endY)) {
                System.out.println("Invalid position. Use columns 'a' to 'h' and rows '1' to '8'.");
                continue;
            }

            Piece selectedPiece = board[startX][startY];
            if (selectedPiece == null) {
                System.out.println("No piece at the selected position.");
                continue;
            }

            ChessPiece.Color currentColor = whiteTurn ? ChessPiece.Color.WHITE : ChessPiece.Color.BLACK;
            if (selectedPiece.getPiece().getColor() != currentColor) {
                System.out.println("You can only move your own pieces.");
                continue;
            }

            Piece destinationPiece = board[endX][endY];
            if (destinationPiece != null && destinationPiece.getPiece().getColor() == currentColor) {
                System.out.println("You can't capture your own piece.");
                continue;
            }

            if (!selectedPiece.validateMoves(endX, endY)) {
                System.out.println("Invalid move.");
                continue;
            }

            selectedPiece.movePiece(endX, endY);
            board[endX][endY] = selectedPiece;
            board[startX][startY] = null;
            whiteTurn = !whiteTurn;
        }

        scanner.close();
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    private static void initializeBoard() {
        // Initialize white pieces
        board[0][0] = new Rook();
        board[0][0].createPiece(ChessPiece.WHITE_ROOK, 0, 0);
        board[1][0] = new Knight();
        board[1][0].createPiece(ChessPiece.WHITE_KNIGHT, 1, 0);
        board[2][0] = new Bishop();
        board[2][0].createPiece(ChessPiece.WHITE_BISHOP, 2, 0);
        board[3][0] = new Queen();
        board[3][0].createPiece(ChessPiece.WHITE_QUEEN, 3, 0);
        board[4][0] = new King();
        board[4][0].createPiece(ChessPiece.WHITE_KING, 4, 0);
        board[5][0] = new Bishop();
        board[5][0].createPiece(ChessPiece.WHITE_BISHOP, 5, 0);
        board[6][0] = new Knight();
        board[6][0].createPiece(ChessPiece.WHITE_KNIGHT, 6, 0);
        board[7][0] = new Rook();
        board[7][0].createPiece(ChessPiece.WHITE_ROOK, 7, 0);
        for (int i = 0; i < 8; i++) {
            board[i][1] = new Pawn();
            board[i][1].createPiece(ChessPiece.WHITE_PAWN, i, 1);
        }

        // Initialize black pieces
        board[0][7] = new Rook();
        board[0][7].createPiece(ChessPiece.BLACK_ROOK, 0, 7);
        board[1][7] = new Knight();
        board[1][7].createPiece(ChessPiece.BLACK_KNIGHT, 1, 7);
        board[2][7] = new Bishop();
        board[2][7].createPiece(ChessPiece.BLACK_BISHOP, 2, 7);
        board[3][7] = new Queen();
        board[3][7].createPiece(ChessPiece.BLACK_QUEEN, 3, 7);
        board[4][7] = new King();
        board[4][7].createPiece(ChessPiece.BLACK_KING, 4, 7);
        board[5][7] = new Bishop();
        board[5][7].createPiece(ChessPiece.BLACK_BISHOP, 5, 7);
        board[6][7] = new Knight();
        board[6][7].createPiece(ChessPiece.BLACK_KNIGHT, 6, 7);
        board[7][7] = new Rook();
        board[7][7].createPiece(ChessPiece.BLACK_ROOK, 7, 7);
        for (int i = 0; i < 8; i++) {
            board[i][6] = new Pawn();
            board[i][6].createPiece(ChessPiece.BLACK_PAWN, i, 6);
        }
    }

    private static void printBoard() {
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                if (board[x][y] != null) {
                    System.out.print(board[x][y].getPiece().getPieceName().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("a b c d e f g h");
    }
}


enum ChessPiece {
    WHITE_KING("King", Color.WHITE),
    WHITE_QUEEN("Queen", Color.WHITE),
    WHITE_ROOK("Rook", Color.WHITE),
    WHITE_BISHOP("Bishop", Color.WHITE),
    WHITE_KNIGHT("Knight", Color.WHITE),
    WHITE_PAWN("Pawn", Color.WHITE),

    BLACK_KING("King", Color.BLACK),
    BLACK_QUEEN("Queen", Color.BLACK),
    BLACK_ROOK("Rook", Color.BLACK),
    BLACK_BISHOP("Bishop", Color.BLACK),
    BLACK_KNIGHT("Knight", Color.BLACK),
    BLACK_PAWN("Pawn", Color.BLACK);

    private final String pieceName;
    private final Color color;

    ChessPiece(String pieceName, Color color) {
        this.pieceName = pieceName;
        this.color = color;
    }

    public String getPieceName() {
        return pieceName;
    }

    public Color getColor() {
        return color;
    }

    public enum Color {
        WHITE, BLACK
    }

    @Override
    public String toString() {
        return color + " " + pieceName;
    }
}

interface Piece {
    ChessPiece getPiece();
    void printPossibleMoves();
    void movePiece(int x, int y);
    void deletePiece();
    void createPiece(ChessPiece piece, int x, int y);
    boolean validateMoves(int x, int y);
}

// Implementing Pawn
class Pawn implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");
        if (piece.getColor() == ChessPiece.Color.WHITE) {
            System.out.println("(" + x + ", " + (y + 1) + ")");
            if (y == 1) {
                System.out.println("(" + x + ", " + (y + 2) + ")");
            }
        } else {
            System.out.println("(" + x + ", " + (y - 1) + ")");
            if (y == 6) {
                System.out.println("(" + x + ", " + (y - 2) + ")");
            }
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        if (piece == null) return false;
        if (piece.getColor() == ChessPiece.Color.WHITE) {
            return (this.x == x && (y == this.y + 1 || (this.y == 1 && y == this.y + 2)));
        } else {
            return (this.x == x && (y == this.y - 1 || (this.y == 6 && y == this.y - 2)));
        }
    }
}

// Implementing Rook
class Rook implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");
        for (int i = 0; i < 8; i++) {
            if (i != x) System.out.println("(" + i + ", " + y + ")");
            if (i != y) System.out.println("(" + x + ", " + i + ")");
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        return (this.piece != null && (this.x == x || this.y == y));
    }
}

// Implementing Bishop
class Bishop implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");
        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y + i < 8) System.out.println("(" + (x + i) + ", " + (y + i) + ")");
            if (x - i >= 0 && y - i >= 0) System.out.println("(" + (x - i) + ", " + (y - i) + ")");
            if (x + i < 8 && y - i >= 0) System.out.println("(" + (x + i) + ", " + (y - i) + ")");
            if (x - i >= 0 && y + i < 8) System.out.println("(" + (x - i) + ", " + (y + i) + ")");
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        return this.piece != null && Math.abs(this.x - x) == Math.abs(this.y - y);
    }
}

// Implementing Knight
class Knight implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");
        int[][] moves = {
                {x + 2, y + 1}, {x + 2, y - 1}, {x - 2, y + 1}, {x - 2, y - 1},
                {x + 1, y + 2}, {x + 1, y - 2}, {x - 1, y + 2}, {x - 1, y - 2}
        };
        for (int[] move : moves) {
            if (move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8) {
                System.out.println("(" + move[0] + ", " + move[1] + ")");
            }
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        int dx = Math.abs(this.x - x);
        int dy = Math.abs(this.y - y);
        return this.piece != null && ((dx == 2 && dy == 1) || (dx == 1 && dy == 2));
    }
}

// Implementing Queen
class Queen implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");

        for (int i = 1; i < 8; i++) {
            if (x + i < 8) System.out.println("(" + (x + i) + ", " + y + ")");
            if (x - i >= 0) System.out.println("(" + (x - i) + ", " + y + ")");
            if (y + i < 8) System.out.println("(" + x + ", " + (y + i) + ")");
            if (y - i >= 0) System.out.println("(" + x + ", " + (y - i) + ")");
            if (x + i < 8 && y + i < 8) System.out.println("(" + (x + i) + ", " + (y + i) + ")");
            if (x - i >= 0 && y - i >= 0) System.out.println("(" + (x - i) + ", " + (y - i) + ")");
            if (x + i < 8 && y - i >= 0) System.out.println("(" + (x + i) + ", " + (y - i) + ")");
            if (x - i >= 0 && y + i < 8) System.out.println("(" + (x - i) + ", " + (y + i) + ")");
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        return this.piece != null && (this.x == x || this.y == y || Math.abs(this.x - x) == Math.abs(this.y - y));
    }
}

// Implementing King
class King implements Piece {
    private ChessPiece piece;
    private int x;
    private int y;

    @Override
    public ChessPiece getPiece() {
        return piece;
    }

    @Override
    public void createPiece(ChessPiece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printPossibleMoves() {
        System.out.println("Possible moves for " + piece + " at (" + x + ", " + y + "):");
        int[][] moves = {
                {x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1},
                {x + 1, y + 1}, {x + 1, y - 1}, {x - 1, y + 1}, {x - 1, y - 1}
        };
        for (int[] move : moves) {
            if (move[0] >= 0 && move[0] < 8 && move[1] >= 0 && move[1] < 8) {
                System.out.println("(" + move[0] + ", " + move[1] + ")");
            }
        }
    }

    @Override
    public void movePiece(int x, int y) {
        if (validateMoves(x, y)) {
            this.x = x;
            this.y = y;
            System.out.println(piece + " moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Invalid move for " + piece);
        }
    }

    @Override
    public void deletePiece() {
        System.out.println(piece + " at (" + x + ", " + y + ") has been removed from the board.");
        this.piece = null;
        this.x = -1;
        this.y = -1;
    }

    @Override
    public boolean validateMoves(int x, int y) {
        return this.piece != null && (Math.abs(this.x - x) <= 1 && Math.abs(this.y - y) <= 1);
    }
}
