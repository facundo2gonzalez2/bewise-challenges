package com.bewise.challenges.sorting;

import java.util.List;



public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {
        
        //Ordeno por nombre de manera ascendente: SelectionSort

        for(int i=0; i < jugadores.size(); i++){
            //Busco el mínimo entre i y n
            int min_index = i;
            for(int j=i+1; j < jugadores.size(); j++){
                String actual = jugadores.get(j).getNombre();
                if(actual.compareTo(jugadores.get(min_index).getNombre()) < 0){
                    min_index = j;
                }
            }
            //Swap min con i
            Jugador aux = jugadores.get(i);
            jugadores.set(i,jugadores.get(min_index));
            jugadores.set(min_index,aux);
        }
        
        
        // Ordeno por puntuación de manera estable para mantener el orden de nombres: InsertionSort

        for(int i=0; i < jugadores.size(); i++){
            int j = i-1;
            Jugador jug = jugadores.get(i);
            while(j>=0 && jugadores.get(j).getPuntuacion() < jug.getPuntuacion()){
                jugadores.set(j+1, jugadores.get(j));
                j--;
            }
            jugadores.set(j+1, jug);
        }


        return jugadores;
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se segxxuirá usando el
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {
        
        //Primero ordenamos por nombres:

        for(int i=0; i < jugadores.size(); i++){
            //Busco el mínimo entre i y n
            int min_index = i;
            for(int j=i+1; j < jugadores.size(); j++){
                String actual = jugadores.get(j).getNombre();
                if(actual.compareTo(jugadores.get(min_index).getNombre()) < 0){
                    min_index = j;
                }
            }
            //Swap min con i
            Jugador aux = jugadores.get(i);
            jugadores.set(i,jugadores.get(min_index));
            jugadores.set(min_index,aux);
        }

        //Ordenamos por partidas perdidas de manera ascendente: (Estable)
        for(int i=0; i < jugadores.size(); i++){
            int j = i-1;
            Jugador jug = jugadores.get(i);
            while(j>=0 && jugadores.get(j).getPerdidas() > jug.getPerdidas()){
                jugadores.set(j+1, jugadores.get(j));
                j--;
            }
            jugadores.set(j+1, jug);
        }

        //Ordenamos por puntaje de manera descendente: (Estable)
        for(int i=0; i < jugadores.size(); i++){
            int j = i-1;
            Jugador jug = jugadores.get(i);
            while(j>=0 && jugadores.get(j).getPuntuacion() < jug.getPuntuacion()){
                jugadores.set(j+1, jugadores.get(j));
                j--;
            }
            jugadores.set(j+1, jug);
        }

        return jugadores;
    }
}
