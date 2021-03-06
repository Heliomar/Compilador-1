/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.back;

import afn.util.ExpressaoAbstrata;
import afn.util.Transicao;

/**
 *
 * @author Lucas
 * Classe responsavel pela concatenação das transiçoes
 */
public class Concatenar extends ExpressaoAbstrata{
    
    @Override
    public Transicao getTransicao(){
        return this.transicao;
    }
       
    @Override
    public Transicao resolver(String expressao, int i) {
       String substringA = expressao.substring(0, i);
       String substringB = expressao.substring(i, expressao.length());
       transicaoA = parser.analisar(substringA);
       transicaoB = parser.analisar(substringB);
       criarAFN();
       return getTransicao();
    }
    
    public Transicao resolver(Transicao a, Transicao b){
        transicaoA = a;
        transicaoB = b;
        criarAFN();
        return getTransicao();
    }
    
    @Override
    protected void criarAFN(){
        this.transicao = new Transicao();
        this.transicao.inico = transicaoA.inico;
        transicao.fim = transicaoB.fim;
        String[][] novaTransicao = new String[][]{{transicaoA.fim, "e", transicaoB.inico}};
        transicao.transicoes = novaTransicao;
        transicao.combinaEstados(transicaoA);
        transicao.combinaEstados(transicaoB);
    }
    
}
