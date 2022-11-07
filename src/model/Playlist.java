package model;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Audio> audioList;
    private ArrayList<int [][]> codeMatrix;
    private int code;


    public Playlist(String name, ArrayList<Audio> audioList, ArrayList<int[][]> codeMatrix, int code) {
        this.name = name;
        this.audioList = audioList;
        this.codeMatrix = codeMatrix;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Audio> getAudioList() {
        return audioList;
    }

    public void setAudioList(ArrayList<Audio> audioList) {
        this.audioList = audioList;
    }

    public ArrayList<int[][]> getCodeMatrix() {
        return codeMatrix;
    }

    public void setCodeMatrix(ArrayList<int[][]> codeMatrix) {
        this.codeMatrix = codeMatrix;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String createMatrix(){
        String out = "";
        int[][] newMatrix = new int[6][6];
        codeMatrix.add(newMatrix);
        out = printNumericMatrix(newMatrix);
        return out;
    }

    private String printNumericMatrix(int[][] numMatrix) {
        String print = "";
        for (int i = 0; i < numMatrix.length; i++) { // filas numbers.length
            for (int j = 0; j < numMatrix[0].length; j++) { // columnas numbers[0].length
                print += numMatrix[i][j] + " ";
            }
            print += "\n";
        }

        return print;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", audioList=" + audioList +
                ", codeMatrix=" + codeMatrix +
                ", code=" + code +
                '}';
    }
}
