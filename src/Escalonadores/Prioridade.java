/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonadores;

import Funcoes.Funcoes;
import Processo.Processo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Renato
 */
public class Prioridade implements Escalona {

    ArrayList<Processo> filaProcessos = new ArrayList<Processo>();
    Funcoes funcoes = new Funcoes();
    boolean fim = false;
    int prioridade = 1;
    double tempo = 0.0;
    String tempoTermino;
    String nome;

    @Override
    public void escalonar() {
        try {
            filaProcessos = funcoes.carregaProcessos();
        } catch (IOException ex) {
            Logger.getLogger(Prioridade.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (!fim) {
            for (int i = 0; i < filaProcessos.size(); i++) {
                fim = true;
                if (filaProcessos.get(i).getEstado()) {
                    
                    continue;
                }
                if(filaProcessos.get(i).getPrioridade()==prioridade){
                    tempo+=filaProcessos.get(i).getTempoExec();
                    filaProcessos.get(i).setTempoFinal(tempo);
                    filaProcessos.get(i).setTerminado(true);
                    fim = false;
                }else{
                    fim = false;
                }

            }
            prioridade++;
        }
        
        for (int i = 0; i < filaProcessos.size(); i++) {
            nome = filaProcessos.get(i).getNome();
            if(nome.endsWith("0")){
                tempoTermino = funcoes.format(filaProcessos.get(i).getTempoFinal());
                funcoes.escreveArquivo(nome, tempoTermino, "Prioridade");
            }
            
        }
    }

}
