package cz.spsmb.ctvrtak.f_pop.b_sudoku_game;

import java.util.ArrayList;
import java.util.Random;

public class Sudoku {
    private int[][] plocha = new int[9][9];

    public void randomFill(){
        Random rnd = new Random();
        // Pole seznamů:
        ArrayList<Integer>[] columns = new ArrayList[this.plocha.length];
        for (int i = 0; i < this.plocha.length; i++) {
            columns[i] = new ArrayList<>();
        }
        for (int i = 0; i < this.plocha.length; i++){
            ArrayList<Integer> actualRow = new ArrayList<>();
            for (int j = 0; j < this.plocha[0].length; j++) {
                int cislo;
                do{
                    cislo = rnd.nextInt(9) + 1;
                } while (actualRow.contains(cislo) || columns[j].contains(cislo));
                actualRow.add(cislo);
                columns[j].add(cislo);
                this.plocha[i][j] = cislo;
            }
            System.out.println("Generuji " + i + "radek");
            System.out.println(this);
        }
    }
    public String toString(){
        StringBuffer tmp = new StringBuffer();
        for (int[] row : this.plocha) {
            for (int cislo : row) {
                tmp.append(cislo+",");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }
    public boolean checkCols() {
        for (int colIdx = 0; colIdx < this.plocha.length; colIdx++) {
            for (int i = 0; i < this.plocha.length; i++) {
                int cislo = this.plocha[i][colIdx];
                for (int j = i + 1; j < this.plocha.length; j++) {
                    if (cislo == this.plocha[j][colIdx]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean checkRows() {
        for (int rowIdx = 0; rowIdx < this.plocha.length; rowIdx++) {
            for (int i = 0; i < this.plocha[rowIdx].length; i++) {
                int cislo = this.plocha[rowIdx][i];
                for (int j = i + 1; j < this.plocha[rowIdx].length; j++) {
                    if (cislo == this.plocha[rowIdx][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean checkWins() {

        return true;
    }
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int cnt = 0;
        //do {
            cnt++;
            sudoku.randomFill();
            System.out.print("\rPočet pokusů: " + cnt);
        //} while( !sudoku.checkCols());
        System.out.println(sudoku);
        System.out.println("Počet pokusů: " + cnt);
    }
}
