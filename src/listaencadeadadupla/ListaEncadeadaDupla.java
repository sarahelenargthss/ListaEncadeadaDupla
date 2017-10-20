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
            System.out.println("__________________________________________________________________________");
            System.out.println("");
            System.out.println("Digite a opção que deseja realizar:");
            System.out.println("1- Incluir um objeto no início na lista;");
            System.out.println("2- Incluir um objeto no final da lista;");
            System.out.println("3- Incluir um objeto em um ponto qualquer entre o primeiro e o último;");
            System.out.println("4- Verificar se um objeto específico está na lista;");
            System.out.println("5- Remover um objeto específico da lista;");
            System.out.println("6- Remover o primeiro objeto da lista;");
            System.out.println("7- Remover o último objeto da lista;");
            System.out.println("8- Mostrar todos os objetos da lista na ordem do primeiro para o último;");
            System.out.println("9- Mostrar todos os objetos da lista na ordem do último para o primeiro;");
            System.out.println("10- Sair.");
            System.out.println("___________________________________________________________________________");
            opcao = pedeInt(1, 10);

            switch (opcao) {
                case 1:
                    insereInicio();
                    break;
                case 2:
                    insereFim();
                    break;
                case 3:
                    //se a lista só possui um objeto, não há como inserir no meio dela, por isso pede-se ao usuário
                    //se ele quer adcionar no início ou no fim
                    if (inicio == termino) {
                        System.out.println("A lista possui somente um filme, deseja adicionar no inicio[1] ou fim[2]?");
                        int aux = pedeInt(1, 2);
                        if (aux == 1) {
                            insereInicio();
                        } else {
                            insereFim();
                        }
                    } else {
                        //pede-se o nome
                        novo = pedeFilme();
                        //o novo objeto vai ser adcionado na segunda posição
                        //o próximo do novo vai ser o próximo do início
                        novo.setProximo(inicio.getProximo());
                        //e o proximo do inicio vai ter o novo como anterior
                        inicio.getProximo().setAnterior(novo);
                        //o proximo do inicio, então, vai ser o novo
                        inicio.setProximo(novo);
                        //e o anterior ao novo vai ser o inicio
                        novo.setAnterior(inicio);
                        System.out.println("Filme inserido!");
                    }
                    break;
                case 4:
                    //se a lista está vazia, não há necessidade em fazer a busca. Então uma mensagem é mostrada avisando
                    //que a lista está vazia
                    if (inicio == null) {
                        System.out.println("A lista está vazia!");
                    } else {
                        //pede-se o nome
                        novo = pedeFilme();
                        //o atual recebe o primeiro objeto da lista para percorre-la
                        atual = inicio;
                        //a variável 'achado' é criada para verificar se o objeto foi achado
                        boolean achado = false;
                        while (atual != null) {
                            //se o atual for igual ao objeto que deve ser encontrado
                            //mostra-se uma mensagem ao usuário 
                            if (atual.getNome().equals(novo.getNome())) {
                                System.out.println("Objeto encontrado! \n Título: " + atual.getNome());
                                //variável 'achado' recebe true pois o objeto foi achado
                                achado = true;
                            }
                            //o atual recebe o proximo obejto da lista
                            atual = atual.getProximo();
                        }
                        if (!achado) {
                            //se o objeto não foi encontrado, mostra-se uma mensagem
                            System.out.println("Objeto não encontrado!");
                        }
                    }
                    break;
                case 5:
                    //se a lista está vazia, mostra-se uma mensagem ao usuário
                    if (inicio == null) {
                        System.out.println("Lista vazia!");
                    } else {
                        //pede-se o nome
                        novo = pedeFilme();
                        //o atual recebe o primeiro objeto da lista
                        atual = inicio;
                        //a variável 'achado' é criada para verificar se o objeto foi achado
                        boolean achado = false;
                        //se o objeto a remover for o primeiro (igual ao inicio), chama-se o método 'removePrimeiro'
                        if (novo.getNome().equals(inicio.getNome())) {
                            removePrimeiro();
                        //se o objeto a remover for o último (igual ao término), chama-se o método 'removeUltimo'
                        } else if (novo.getNome().equals(termino.getNome())) {
                            removeUltimo();
                        } else {
                            while (atual != null) {
                                //se o objeto for encontrado (atual for igual ao que o usuário quer remover)
                                if (novo.getNome().equals(atual.getNome())) {
                                    //variável 'achado' recebe true
                                    achado = true;
                                    //o anterior ao atual recebe como próximo o próximo do atual
                                    atual.getAnterior().setProximo(atual.getProximo());
                                    //o próximo do atual recebe como anterior o anterior ao atual
                                    atual.getProximo().setAnterior(atual.getAnterior());
                                    System.out.println("Filme removido da lista!");
                                }
                                //atual recebe o próximo objeto da lista
                                atual = atual.getProximo();
                            }
                            if (!achado) {
                                //se a variável achado continuou como false, o objeto não foi encontrado e mostra-se uma mensagem ao usuário
                                System.out.println("Objeto não encontrado!");
                            }
                        }
                    }
                    break;
                case 6:
                    //se a lista está vazia mostra-se uma mensagem
                    if (inicio == null) {
                        System.out.println("Lista vazia!");
                    } else {
                        //chama-se o método removePrimeiro
                        removePrimeiro();
                    }
                    break;
                case 7:
                    //se a lista está vazia mostra-se uma mensagem
                    if (inicio == null) {
                        System.out.println("Lista vazia!");
                    } else {
                        //chama-se o método removeUltimo
                        removeUltimo();
                    }
                    break;
                case 8:
                    //se a lista está vazia mostra-se uma mensagem
                    if (inicio == null) {
                        System.out.println("Lista vazia!");
                    } else {
                        //atual recebe o inicio para começar a percorre a lista 
                        //e mostrá-la de forma "crescente" com relações as posições
                        atual = inicio;
                        while (atual != null) {
                            //mostra-se o nome do filme a cada objeto da lista
                            System.out.println("Título: " + atual.getNome());
                            //atual recebe o próximo objeto da lista
                            atual = atual.getProximo();
                        }
                    }
                    break;
                case 9:
                    //se a lista está vazia mostra-se uma mensagem
                    if (inicio == null) {
                        System.out.println("Lista vazia!");
                    } else {
                        atual = termino;
                        while (atual != null) {
                            System.out.println("Título: " + atual.getNome());
                            atual = atual.getAnterior();
                        }
                    }
                    break;
                case 10:
                    System.out.println("Até mais, humano! ^.^");
                    break;
            }

        } while (opcao != 10);
    }

    private static int pedeInt(int min, int max) {
        Scanner leia = new Scanner(System.in);
        int intOpcao = 0;
        boolean erro;
        do {
            erro = false;
            try {
                //pede-se um número inteiro 
                intOpcao = leia.nextInt();
                ///verifica-se se o número digitado está dentro dos limites
                if (intOpcao > max || intOpcao < min) {
                    //se o número excede os limites, variável 'erro' recebe true
                    erro = true;
                    System.out.println("Opção inválida! Digite novamente:");
                }
            } catch (InputMismatchException e) {
                //se o que foi digitado não corresponde a um número inteiro
                //variável 'erro' recebe true
                erro = true;
                System.out.println("Opção inválida! Digite novamente:");
            }
            //se houve erro (variável erro igual a true), repete-se a estrutura para que 
            //o usuário digite novamente
        } while (erro);
        return intOpcao;
    }

    private static Filme pedeFilme() {
        Scanner leia = new Scanner(System.in);
        Filme filme = new Filme();
        do {
            //pede-se o nome do filme
            System.out.println("Digite o nome do filme:");
            filme.setNome(leia.nextLine().trim());
            //verifica-se se o que foi digitado está vazio, e pede-se que seja 
            //digitado novamente, pois o nome anterior era inválido
            if (filme.getNome().equals("")) {
                System.out.print("Nome inválido! ");
            }
        } while (filme.getNome().equals(""));
        return filme;
    }

    private static void insereInicio() {
        //pde-se o nome
        novo = pedeFilme();
        //o meu novo objeto vai ter como próximo aquele que agora é o início
        novo.setProximo(inicio);
        //o menu novo agora é o início
        inicio = novo;
        //se a lista estava vazia o novo também vai ser o último
        if (termino == null) {
            termino = novo;
        }
        System.out.println("Filme inserido!");
    }

    private static void insereFim() {
        //pede-se o nome
        novo = pedeFilme();
        //o último objeto vai ter como próximo o novo
        termino.setProximo(novo);
        //o anterior ao novo vai ser aquele que é o atual término
        novo.setAnterior(termino);
        //o término agora vai ser o novo
        termino = novo;
        //se a lista estava vazia o novo também vai ser o primeiro
        if (inicio == null) {
            inicio = novo;
        }
        System.out.println("Filme inserido!");
    }

    private static void removePrimeiro() {
        //verifica-se se há somente um objeto na lista
        if (inicio == termino) {
            //nesse caso o inicio e o término vão ser nulos
            inicio = null;
            termino = null;
        } else {
            //se há mais de um objeto na lista
            //o próximo do inicio (o segundo objeto)
            //vai ter o anterior nulo, pois vai passar a ser o primeiro
            inicio.getProximo().setAnterior(null);
            //o inicio recebe o proximo do inicio (que é o segundo)
            inicio = inicio.getProximo();
        }
        System.out.println("Objeto removido!");
    }

    private static void removeUltimo() {
        //verifica-se se há somente um objeto na lista
        if (inicio == termino) {
            //nesse caso o inicio e o término vão ser nulos
            inicio = null;
            termino = null;
        } else {
            //se há mais de um objeto na lista
            //o anterior ao termino vai ter o proximo nulo
            termino.getAnterior().setProximo(null);
            //o termino vai ser agora o anterior ao que antes era o termino (o penúltimo)
            termino = termino.getAnterior();
        }
        System.out.println("Objeto removido!");
    }

}
