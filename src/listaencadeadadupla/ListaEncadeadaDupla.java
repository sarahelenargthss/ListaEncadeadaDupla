package listaencadeadadupla;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaEncadeadaDupla {
    
    static Filme inicio = null;
    static Filme termino = null;
    static Filme novo = null;
    
    public static void main(String[] args) {
        
        int opcao;
        Filme atual;
        
        do {
            
            System.out.println("Digite a opção que deseja realizar:");
            System.out.println("1- Incluir um objeto no início na lista");
            System.out.println("2- Incluir um objeto no final da lista");
            System.out.println("3- Incluir um objeto em um ponto qualquer entre o primeiro e o último.");
            System.out.println("4- Verificar se um objeto específico está na lista");
            System.out.println("5- Remover um objeto específico da lista");
            System.out.println("6- Remover o primeiro objeto da lista");
            System.out.println("7- Remover o último objeto da lista");
            System.out.println("8- Mostrar todos os objetos da lista na ordem do primeiro para o último");
            System.out.println("9- Mostrar todos os objetos da lista na ordem do último para o primeiro");
            System.out.println("10- Sair.");
            opcao = pedeInt(1, 10);
            
            switch (opcao) {
                case 1:
                    insereInicio();
                    break;
                case 2:
                    insereFim();
                    break;
                case 3:
                    if (inicio == termino) {
                        System.out.println("A lista possui somente um filme, deseja adicionar no inicio[1] ou fim[2]?");
                        int aux = pedeInt(1, 2);
                        if (aux == 1) {
                            insereInicio();
                        } else {
                            insereFim();
                        }
                    } else {
                        novo = pedeFilme();
                        novo.setProximo(inicio.getProximo());
                        inicio.getProximo().setAnterior(novo);
                        inicio.setProximo(novo);
                        novo.setAnterior(inicio);
                        System.out.println("Filme inserido!");
                    }
                    break;
                case 4:
                    novo = pedeFilme();
                   if(inicio == null){
                       System.out.println("A lista está vazia!");
                   }else{
                    atual = inicio;
                    boolean achado = false;
                    while(atual != null){
                        if(atual.getNome().equals(novo.getNome())){
                            System.out.println("Objeto encontrado! \n Título: " + atual.getNome());
                            achado = true;
                        }
                        atual = atual.getProximo();
                    }
                    if(!achado){
                        System.out.println("Objeto não encontrado!");
                    }
                   }
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
            }
            
        } while (opcao != 10);
    }
    
    private static int pedeInt(int min, int max) {
        Scanner leia = new Scanner(System.in);
        int intOpcao = 0;
        boolean erro = false;
        do {
            try {
                intOpcao = leia.nextInt();
                if (intOpcao > max || intOpcao < min) {
                    erro = true;
                    System.out.println("Opção inválida! Digite novamente:");
                }
            } catch (InputMismatchException e) {
                erro = true;
                System.out.println("Opção inválida! Digite novamente:");
            }
        } while (erro);
        return intOpcao;
    }
    
    private static Filme pedeFilme() {
        Scanner leia = new Scanner(System.in);
        Filme novo = null;
        novo.setAnterior(null);
        novo.setProximo(null);
        do {
            System.out.println("Digite o nome do filme:");
            novo.setNome(leia.nextLine().trim());
            if (novo.getNome().equals("")) {
                System.out.print("Opção inválida! ");
            }
        } while (novo.getNome().equals(""));
        return novo;
    }
    
    private static void insereInicio() {
        novo = pedeFilme();
        novo.setProximo(inicio);
        inicio = novo;
        if (termino == null) {
            termino = novo;
        }
        System.out.println("Filme inserido!");
    }
    
    private static void insereFim() {
        novo = pedeFilme();
        termino.setProximo(novo);
        novo.setAnterior(termino);
        termino = novo;
        if (inicio == null) {
            inicio = novo;
        }
        System.out.println("Filme inserido!");
    }
    
}
