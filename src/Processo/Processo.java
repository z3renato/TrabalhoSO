/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processo;

/**
 *
 * @author José Renato
 */
public class Processo {
   private String nome;
     private double tempoExec;
     private int prioridade;
     private int prioridadeOriginal;
     private double tempoFinal;
     private boolean pronto=false;
     public Processo(String nome, double tempoExec, int prioridade){
         this.nome = nome;
         this.tempoExec = tempoExec;
         this.prioridade = prioridade;
         prioridadeOriginal = prioridade;
     }

        public boolean getEstado(){
         return pronto;
     }
     public void setTerminado(boolean estado){
         this.pronto = estado;
     }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoExec() {
        return tempoExec;
    }

    public void setTempoExec(double tempoExec) {
        this.tempoExec = tempoExec;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public double getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(double tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
     
    public int getPrioridadeOriginal(){
        return prioridadeOriginal;
    }
}
