/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.Ejercicio2;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/**
 *
 * @author Oscar
 */
public class Metodos {
    public static String Vocales(String inputLexer){
        Reader reader = new StringReader(inputLexer);
        Flex f = new Flex(reader);
        try {
            int output = f.yylex();
            while (output != f.YYEOF) {
                f.yylex();
            }
            int[][] posicionesDigitos = f.getPosicionDigito();
            String textoPosicionDigitos = "";
            for (int i = 0; i < posicionesDigitos.length; i++) {
                textoPosicionDigitos += posicionesDigitos[i][0]+"\t"+posicionesDigitos[i][1]+"\n";
            }
            String outputString =
                "Palabras con una vocal:\t\t"+f.getUnaVocal().length+"\n"+
                getVocales(f.getUnaVocal())+
                "Palabras con dos vocales:\t\t"+f.getDosVocales().length+"\n"+
                getVocales(f.getDosVocales())+
                "Palabras con tres vocales:\t\t"+f.getTresVocales().length+"\n"+
                getVocales(f.getTresVocales())+
                "Palabras con cuatro vocales:\t\t"+f.getCuatroVocales().length+"\n"+
                getVocales(f.getCuatroVocales())+
                "Palabras con cinco vocales:\t\t"+f.getCincoVocales().length+"\n"+
                getVocales(f.getCincoVocales())+
                "Palabras con mas de cinco vocales:\t"+f.getMasVocales().length+"\n"+
                getVocales(f.getMasVocales())
            ;
            return outputString;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ha ocurrido un error";
        }
    }
    
    private static String getVocales(String[] arregloPalabras){
        String palabras = "";
        for (String palabra : arregloPalabras) {
            palabras += "->  "+palabra+"\n";
        }
        return palabras;
    }
    
    public static String Numeros(String inputLexer){
        Reader reader = new StringReader(inputLexer);
        Flex f = new Flex(reader);
        try {
            int output = f.yylex();
            while (output != f.YYEOF) {
                f.yylex();
            }
            int[][] posicionDigitos = f.getPosicionDigito();
            String textoPosicionesDigitos = "";
            for (int i = 0; i < posicionDigitos.length; i++) {
                textoPosicionesDigitos += posicionDigitos[i][0]+"\t"+posicionDigitos[i][1]+"\n";
            }
            String outputString =
                "Posicion de Digitos:\n"+
                "Linea\tColumna\n"+
                textoPosicionesDigitos
            ;
            return outputString;
        } catch (IOException e) {
            e.printStackTrace();
            return "Ha ocurrido un error";
        }
    }
}
