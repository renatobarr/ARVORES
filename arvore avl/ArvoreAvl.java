class ArvoreAvl {
    private No raiz;

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    private No inserir(No no, int chave) {
        if (no == null)
            return new No(chave);

        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balance = fatorBalanceamento(no);

        if (balance > 1 && chave < no.esquerda.chave)
            return rotacaoDireita(no);
        if (balance < -1 && chave > no.direita.chave)
            return rotacaoEsquerda(no);
        if (balance > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balance < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void excluir(int chave) {
        raiz = excluir(raiz, chave);
    }

    private No excluir(No raiz, int chave) {
        if (raiz == null)
            return raiz;

        if (chave < raiz.chave)
            raiz.esquerda = excluir(raiz.esquerda, chave);
        else if (chave > raiz.chave)
            raiz.direita = excluir(raiz.direita, chave);
        else {
            if ((raiz.esquerda == null) || (raiz.direita == null)) {
                No temp = (raiz.esquerda != null) ? raiz.esquerda : raiz.direita;
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else {
                No temp = minValorNo(raiz.direita);
                raiz.chave = temp.chave;
                raiz.direita = excluir(raiz.direita, temp.chave);
            }
        }

        if (raiz == null)
            return raiz;

        raiz.altura = Math.max(altura(raiz.esquerda), altura(raiz.direita)) + 1;
        int balance = fatorBalanceamento(raiz);

        if (balance > 1 && fatorBalanceamento(raiz.esquerda) >= 0)
            return rotacaoDireita(raiz);
        if (balance > 1 && fatorBalanceamento(raiz.esquerda) < 0) {
            raiz.esquerda = rotacaoEsquerda(raiz.esquerda);
            return rotacaoDireita(raiz);
        }
        if (balance < -1 && fatorBalanceamento(raiz.direita) <= 0)
            return rotacaoEsquerda(raiz);
        if (balance < -1 && fatorBalanceamento(raiz.direita) > 0) {
            raiz.direita = rotacaoDireita(raiz.direita);
            return rotacaoEsquerda(raiz);
        }

        return raiz;
    }

    private No minValorNo(No no) {
        No atual = no;
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.chave + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public boolean buscar(int chave) {
        return buscar(raiz, chave);
    }

    private boolean buscar(No no, int chave) {
        if (no == null) return false;
        if (chave == no.chave) return true;
        return chave < no.chave ? buscar(no.esquerda, chave) : buscar(no.direita, chave);
    }
}

