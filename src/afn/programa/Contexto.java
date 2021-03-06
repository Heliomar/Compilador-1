/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.programa;

import afn.front.AFNParser;
import afn.util.Transicao;

/**
 *
 * @author Lucas
 */
class Contexto {
    AFNParser parser;
    Transicao resultado;
    
    public  Contexto(){
        parser = new AFNParser();
        parser.init();
    }
    public String[][] gerarAFN(String expressao) {       
        resultado = parser.analisar(expressao);
        return resultado.transicoes;
    }
    
    public String getInicio(){
        return resultado.inico;
    }
    
    public String getFim(){
        return resultado.fim;
    }
}
