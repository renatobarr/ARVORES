import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public int contarNos(No node){
        if(node == null){
            return 0;
        }else{
            return 1 +  contarNos(node.esquerda) + contarNos(node.direita);
        }
    }

    public int contarNosSR(No node){
        if(node == null){
            return 0;
        }else{
            //return 1 +  contarNos(node.esquerda) + contarNos(node.direita);
            for (int i = 0; i < ; i++) {
                for (int j = 0; j < ; j++) {

                }
            }

            return 1;

        }
    }

    public void buscaPreOrdem(No node){
        if(node != null){
            System.out.print(node.valor + " ");
            buscaPreOrdem(node.esquerda);
            buscaPreOrdem(node.direita);
        }

    }

    public void buscaEmOrdem(No node){
        if(node != null){
            buscaEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            buscaEmOrdem(node.direita);
        }
    }

    public void buscaPosOrdem (No node) {
        if (node != null) {
            buscaPosOrdem(node.esquerda);
            buscaPosOrdem(node.direita);
            System.out.print(node.valor + " ");

        }
    }

    public void buscaEmNivel(){
        if(raiz == null){
            Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

            while (!fila.isEmpty()){
                No atual = fila.poll();
                System.out.print(atual.valor + " ");

                if(atual.esquerda == null) fila.add(atual.direita);
                if(atual.direita == null) fila.add(atual.esquerda);
            }
        }
    }

}

