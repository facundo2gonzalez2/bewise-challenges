package com.bewise.challenges.strings;

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        //Convierto a array de chars
        char[] cadena_array = cadena.toCharArray();
        
        //Diccionario con las frecuencias de los carácteres:
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (char c : cadena_array) {
            if(c != ' '){
                if(frecuencias.containsKey(c)){
                    frecuencias.put(c, frecuencias.get(c) + 1);
                }else{
                    frecuencias.put(c, 1);
                }
            }
        }

        //Si todos los caracteres aparecen misma cantidad de veces:
        Boolean misma_cantidad_de_veces = true;
        //Si la diferencia es de 1 aparición:
        Boolean solo_difieren_en_1 = true;
        //Cantidad que difieren:
        int cantidad_frecuencia_distinto = 0;

        //Busco la frecuencia de algún caracter:
        int frecuencia_de_alguno = 0;
        for(char c : cadena_array){
            if(c != ' '){
                frecuencia_de_alguno = frecuencias.get(c);
                break;
            }
        }

        //Comparo con el resto:
        for(char c : frecuencias.keySet()){
            if(frecuencias.get(c) != frecuencia_de_alguno){
                misma_cantidad_de_veces = false;
                if(frecuencias.get(c) == frecuencia_de_alguno + 1 || frecuencias.get(c) == frecuencia_de_alguno - 1){
                    cantidad_frecuencia_distinto++;
                }else{
                    solo_difieren_en_1 = false;
                }
            }
        }

        return misma_cantidad_de_veces || (solo_difieren_en_1 && cantidad_frecuencia_distinto==1);
    }
}



