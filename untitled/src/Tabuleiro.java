public class Tabuleiro {
    private int tamanho;
    int [][] celula;

    public Tabuleiro (int tamanho) {
        this.tamanho= tamanho;
        celula = new int [tamanho][tamanho];
        for (int i=0; i<tamanho;i++) {
            for(int j=0; j<tamanho;j++) {
                celula[i][j] = 0;
            }
        }
    }
    public void printTabuleiro() {
        System.out.print("   ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        for (int i = 0; i < tamanho; i++) {
            System.out.print((char) ('|') + " ");
            for (int j = 0; j < tamanho; j++) {
                if (celula[i][j] == 'R') {
                    System.out.print("\u001B[31mO ");
                } else if (celula[i][j] == 'Y') {
                    System.out.print("\u001B[33mO ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }

    public boolean jogar(int coluna, Jogador jogador) {
        if (coluna >= 0 && coluna < tamanho) {
            for (int i = tamanho - 1; i >= 0; i--) {
                if (celula[i][coluna] == ' ') {
                    celula[i][coluna] = jogador.getCor();
                    return true;
                }
            }
        }
        return false;
    }

    public void inserirPedra(int x, int y, Pedra pedra) {
        if (x >= 0 && x < tamanho && y >= 0 && y < tamanho) {
            char cor = pedra.getCor();
            celula[x][y] = cor;
        } else {
            System.out.println("Posição inválida!");
        }
    }

    public void setPedra(int x, int y, char cor) {
        if(cor == 'R') {
            celula[x][y] = 1;
        }
        else if (cor == 'Y') {
            celula[x][y] = 2;
        }
    }
    public int getTamanho() {
        return this.tamanho;
    }
}