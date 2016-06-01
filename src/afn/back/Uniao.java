 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afn.back;

import afn.util.ExpressaoAbstrata;

/**
 *
 * @author Lucas
 */
public class Uniao extends ExpressaoAbstrata{

    @Override
    protected void criarAFN() {
        String[][] novaTransicao = new String[][]{
            {transicao.inico, "e", transicaoA.inico},
            {transicao.inico, "e", transicaoB.inico},
            {transicaoA.fim, "e", transicao.fim},
            {transicaoB.fim, "e", transicao.fim}
        };
        
        this.transicao.transicoes = novaTransicao;
        transicao.combinaEstados(transicaoA);
        transicao.combinaEstados(transicaoB);
    }
}
