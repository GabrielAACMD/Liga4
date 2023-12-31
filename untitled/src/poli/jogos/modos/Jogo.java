package poli.jogos.modos;

import poli.jogos.Jogador;
import poli.jogos.Tabuleiro;
import poli.jogos.Vitoria;
import poli.jogos.modos.Modo;

import java.util.Scanner;

public class Jogo implements Modo {

    protected Jogador jogador1;
    protected Jogador jogador2;
    protected int tamanho;
    protected Tabuleiro tabuleiro;

    public Jogo(Jogador jogador1, Jogador jogador2, int tamanho) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tamanho = tamanho;
        this.tabuleiro = new Tabuleiro(tamanho);
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;
        boolean jogoFinalizado = false;

        while (!jogoFinalizado) {
            System.out.println("=== Vez do jogador: " + jogador1.getNome() + " ===");
            boolean jogadaValida = false;
            do {

                tabuleiro.printTabuleiro();

                System.out.print("Informe a coluna onde deseja jogar (0-" + (tamanho - 1) + "): ");
                int coluna = scanner.nextInt();

                if (verificarDisponibilidade(coluna, jogador1.getCor())) {
                    jogadas++;
                    jogadaValida = true;

                    if (Vitoria.jogadorVenceu(tabuleiro, jogador1, tamanho)) {
                        System.out.println("Parabéns, " + jogador1.getNome() + "! Você venceu!");
                        tabuleiro.printTabuleiro();
                        jogoFinalizado = true;
                    } else if (jogadas == tamanho * tamanho) {
                        System.out.println("O jogo terminou em empate!");
                        tabuleiro.printTabuleiro();
                        jogoFinalizado = true;
                    }
                } else {
                    System.out.println("Jogada inválida. Tente novamente.");
                }
            } while(!jogadaValida);

            Jogador atual = jogador1;
            jogador1 = jogador2;
            jogador2 = atual;
        }
    }

    public boolean verificarDisponibilidade(int coluna, char cor){
        if(coluna<0 || coluna>=tamanho){
            return false;
        } else {
            for(int i = tamanho - 1;i>=0;i--){
                if (tabuleiro.getCelula()[i][coluna] == 0) {
                    tabuleiro.getCelula()[i][coluna] = cor;
                    return true;
                }
            }
        }return true;
    }
}
