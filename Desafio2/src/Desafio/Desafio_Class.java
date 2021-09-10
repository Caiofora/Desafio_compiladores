package Desafio;


import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
public class Desafio_Class {
	
    //private static final char open_parentese = '(';
    public static Scanner arq;
    public static void main(String[] args) throws IOException {
        ArrayList <String> agrupamento = new ArrayList<String>();
        try {
          arq=new Scanner(new FileReader("prog.txt"));
          
          while (arq.hasNextLine()){
        	  agrupamento.add(arq.nextLine());
          }
        } catch (IOException e) {
            System.err.printf("Erro durante a abertura de arquivo: %s.\n",
              e.getMessage());
        }
        FileWriter arquivo = new FileWriter("prog-check.txt");
        PrintWriter salvaArq = new PrintWriter(arquivo);
        int tamanho= agrupamento.size();
        Stack<Character> lista = new Stack<Character>();
        for(int u=0;u<tamanho;u++){


            boolean incorreto=false;
            String agrupamento2 = agrupamento.get(u).toString();                              
            System.out.println(agrupamento2);
            char maior = '>';
            char menor = '<';
            char open_parenteses = '(';
            char close_parenteses = ')';
            char open_colchete = '[';
            char close_colchete = ']';
            char open_chave = '{';
            char close_chave = '}';

            
            for (int i = 0; i < agrupamento2.length(); i++){
            if (agrupamento2.charAt(i) == open_colchete) {
                lista.push(open_colchete);
            } else if (agrupamento2.charAt(i) == open_chave){
                lista.push(open_chave);
            }else if (agrupamento2.charAt(i) == menor){
                lista.push(menor);
            } else if (agrupamento2.charAt(i) ==open_parenteses){
                lista.push(open_parenteses);
            }else if (agrupamento2.charAt(i) == close_colchete){
                if (lista.isEmpty()){
                    incorreto = true;
                    break;
                }
                if (lista.pop() != open_colchete){
                    incorreto = true;
                    break;
                }
            }else if (agrupamento2.charAt(i) == close_chave){
                if (lista.isEmpty()){
                    incorreto = true;
                    break;
                }
                if (lista.pop() != open_chave){
                    incorreto = true;
                    break;
                }              
            } else if (agrupamento2.charAt(i) == close_parenteses){
                if (lista.isEmpty()){
                    incorreto = true;
                    break;
                }
                if (lista.pop() != open_parenteses){
                    incorreto = true;
                    break;
                }
            }else if (agrupamento2.charAt(i) == maior){
                if (lista.isEmpty()){
                    incorreto = true;
                    break;
                }
                if (lista.pop() != menor){
                    incorreto = true;
                    break;
                }              
            }    
        }           
            
        lista.clear();
        
        
        if (incorreto == true){
        	agrupamento2 = agrupamento2 + " - Incorreto";
        }
        else{
        	agrupamento2 = agrupamento2 + " - Correto";
        }
        try{
            salvaArq.println(agrupamento2);
            //System.out.println(agrupamento2);
        }
        catch(Exception e){
            System.err.printf("Erro no salvamento do arquivo: %s.\n",
              e.getMessage());
        }

    }
    arquivo.close();
}

}


