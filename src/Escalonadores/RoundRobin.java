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
public class RoundRobin implements Escalona {

    double quantum = 30.0, tempoTotal = 0.0;
    String nome, tempoTermino;
    boolean fim = false;
    Funcoes funcoes = new Funcoes();
    ArrayList<Processo> listaProcesso = new ArrayList<Processo>();

    public double getQuantum() {
        return quantum;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    @Override
    public void escalonar() {

        try {
            listaProcesso = funcoes.carregaProcessos();
        } catch (IOException ex) {
            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!fim) {
            for (int i = 0; i < listaProcesso.size(); i++) {
                fim = true;
                if (listaProcesso.get(i).getEstado()) {
                    fim = true;
                    continue;
                }

                if (listaProcesso.get(i).getTempoExec() <= quantum) {
                    tempoTotal += listaProcesso.get(i).getTempoExec();
                    listaProcesso.get(i).setTempoFinal(tempoTotal);
                    listaProcesso.get(i).setTerminado(true);
                    fim = false;
                } else {
                    tempoTotal += quantum;
                    listaProcesso.get(i).setTempoExec(listaProcesso.get(i).getTempoExec() - quantum);
                    fim = false;
                }
            }
        }

        for (int i = 0; i < listaProcesso.size(); i++) {
            nome = listaProcesso.get(i).getNome();
            if (nome.endsWith("0")) {
                tempoTermino = funcoes.format(listaProcesso.get(i).getTempoFinal());
                funcoes.escreveArquivo(nome, tempoTermino, "RoundRobin");
            }
        }

    }

}
