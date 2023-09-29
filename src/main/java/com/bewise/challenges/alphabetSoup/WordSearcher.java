package com.bewise.challenges.alphabetSoup;
import java.util.ArrayList;
import java.util.List;


public class WordSearcher {
    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }

    //Método auxiliar: se fija si (i,j) ya fue visitado:
    private boolean yaVisitado(int i, int j, List<int[]> posiciones){
        //Me fijo si (i,j) ya fue visitado en posiciones
        for(int k=0;k<posiciones.size();k++){
            int[] pos = posiciones.get(k);
            if(pos[0]==i && pos[1]==j){
                return true;
            }
        }
        return false;
    } 

   //Se fija si esta la palabra desde index desde una casilla (i,j)
   public boolean isPresentCoord(String word, List<int[]> posiciones, int index){
        //La última posición es desde la que avanzo
        int[] actual = posiciones.get(posiciones.size()-1);
        int i = actual[0];
        int j = actual[1];

        char[] caracteres = word.toCharArray();

        if(caracteres.length == index){
            return true;
        }
        boolean siguientes = false;
        
        //Para cada caso me fijo avanzando en esa dirección, y despues la saco de la lista para los otros casos:

        if(i+1 < soup.length && !yaVisitado(i+1, j, posiciones)) {
            if(soup[i+1][j] == caracteres[index]){
                int[] nuevas = {i+1,j};
                posiciones.add(nuevas);
                siguientes = siguientes || isPresentCoord(word, posiciones, index+1);
                posiciones.remove(posiciones.size()-1);
            }
        }
        if(i-1 >= 0 && !yaVisitado(i-1, j, posiciones)) {
            if(soup[i-1][j] == caracteres[index]){
                int[] nuevas = {i-1,j};
                posiciones.add(nuevas);
                siguientes = siguientes || isPresentCoord(word, posiciones, index+1);
                posiciones.remove(posiciones.size()-1);
            }
        }
        if(j+1 < soup[i].length && !yaVisitado(i, j+1, posiciones)) {
            if(soup[i][j+1] == caracteres[index]){
                int[] nuevas = {i,j+1};
                posiciones.add(nuevas);
                siguientes = siguientes || isPresentCoord(word, posiciones, index+1);
                posiciones.remove(posiciones.size()-1);
            }
        }
        if(j-1 >=0 && !yaVisitado(i, j-1, posiciones)) {
            if(soup[i][j-1] == caracteres[index]){
                int[] nuevas = {i,j-1};
                posiciones.add(nuevas);
                siguientes = siguientes || isPresentCoord(word, posiciones, index+1);
                posiciones.remove(posiciones.size()-1);
            }
        }

        return siguientes;
    }

    //El método tiene en cuenta no pasar 2 veces por la misma casilla, para eso se utiliza la lista posiciones.
    public boolean isPresent(String word) {
        char[] caracteres = word.toCharArray();

        for(int i=0; i < soup.length;i++){
            for(int j = 0; j < soup[i].length; j++ ){
                if (soup[i][j]==caracteres[0]){
                    List<int[]> posiciones = new ArrayList<>();
                    int[] iniciales = {i,j};
                    posiciones.add(iniciales);
                    if(isPresentCoord(word, posiciones, 1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}