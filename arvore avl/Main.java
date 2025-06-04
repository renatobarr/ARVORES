import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreAvl avl = new ArvoreAvl();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Árvore AVL ---");
            System.out.println("1. Inserir");
            System.out.println("2. Excluir");
            System.out.println("3. Buscar");
            System.out.println("4. PreOrdem");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a chave a inserir: ");
                    int chaveInsere = sc.nextInt();
                    avl.inserir(chaveInsere);
                    break;
                case 2:
                    System.out.print("Digite a chave a excluir: ");
                    int chaveExclui = sc.nextInt();
                    avl.excluir(chaveExclui);
                    break;
                case 3:
                    System.out.print("Digite a chave a buscar: ");
                    int chaveBusca = sc.nextInt();
                    boolean encontrado = avl.buscar(chaveBusca);
                    System.out.println(encontrado ? "Chave encontrada." : "Chave não encontrada.");
                    break;
                case 4:
                    System.out.println("PreOrdem:");
                    avl.preOrdem();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
