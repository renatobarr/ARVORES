public class No {

    String valor;
    No esquerda, direita;
    public int altura;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class No {
    String conteudo;
    No filhoEsquerdo, filhoDireito;
    int balanceamento;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.balanceamento = 0;
    }
}
