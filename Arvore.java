public class Arvore {
    No raiz;

    public int contarNos(No node){
        if(node == null){
            return 0;
        }else{
            return 1 +  contarNos(node.esquerda) + contarNos(node.direita);
        }
    }
}

