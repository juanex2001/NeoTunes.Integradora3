package model;

import java.util.ArrayList;
import java.util.Random;

public class Playlist {
    private String name;
    private ArrayList<Audio> audioList;
    private int[][] codeMatrix;
    private String code;

    private int reproductionNum;

    Random random = new Random();

    public Playlist(String name, String code, int reproductionNum) {
        this.name = name;
        this.codeMatrix = new int[6][6];
        this.code = code;
        this.reproductionNum = reproductionNum;
        this.audioList = new ArrayList<Audio>();
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

    public int[][] getCodeMatrix() {
        return codeMatrix;
    }

    public void setCodeMatrix(int[][] codeMatrix) {
        this.codeMatrix = codeMatrix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getReproductionNum() {
        return reproductionNum;
    }

    public void setReproductionNum(int reproductionNum) {
        this.reproductionNum = reproductionNum;
    }

    public void createMatrix(){
        String out = "";
        for(int i = 0; i<codeMatrix.length; i++){
            for(int j = 0; j<codeMatrix.length; j++){
                codeMatrix[i][j] = random.nextInt(9);
            }
        }

        out = printNumericMatrix(codeMatrix);
        System.out.println(out);
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

    public void addAudio(Audio Song, Audio Podcast){
        if(Song == null){
            audioList.add(Podcast);
        } else if (Podcast == null){
            audioList.add(Song);
        } else {
            audioList.add(Song);
            audioList.add(Podcast);
        }
    }
    public void remAudio(Audio Song, Audio Podcast){
        if(Song == null){
            for(int i=0; i<audioList.size(); i++){
                if(audioList.isEmpty()){
                    if(audioList.get(i)==Podcast){
                        audioList.remove(audioList.get(i));
                        break;
                    }
                }
            }
        } else if (Podcast == null){
            for(int i=0; i<audioList.size(); i++){
                if(audioList.isEmpty()){
                    if(audioList.get(i)==Song){
                        audioList.remove(audioList.get(i));
                        break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", audioList=" + audioList +
                ", codeMatrix=" + codeMatrix +
                ", code=" + code +
                ", reproductionNum=" + reproductionNum +
                '}';
    }
}
