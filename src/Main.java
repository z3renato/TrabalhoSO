
import Escalonadores.Prioridade;
import Escalonadores.RoundRobin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author José Renato
 */
public class Main {
    public static void main(String[] args) {
        RoundRobin round = new RoundRobin();
        Prioridade prioridade = new Prioridade();
        round.escalonar();
        prioridade.escalonar();
    }
}
