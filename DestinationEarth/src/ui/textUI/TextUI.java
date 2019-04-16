package ui.textUI;

import controllers.Game;
import controllers.stats.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Aqui tera todas as funcoes de interfase (consola) com o utilizador Em mais
 * nenhuma parte do programa se vai fazer prints Sempre que se quiser fazer um
 * print teremos de chamar uma funcao daqui Tudo o que e interacao com o
 * utilizador e aqui que se faz
 *
 * @author Leonardo
 */
public class TextUI {

    private Game game;
    private boolean quit = false;

    public TextUI(Game game) {
        this.game = game;
    }

    public void run() {
        while (!quit) {
            IStates state = game.getState();
            if (state instanceof AwaitBeginning) {
                uiAwaitBeginning();
            }
        }
    }

    public void choseSettings() {
        Scanner sc = new Scanner(System.in);
        int option;
        int a = 0;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println();
            System.out.println("\t0 - Voltar");
            System.out.println("\t1 - Definir Hp(0-12)");
            System.out.println("\t2 - Definir Hull(0-12)");
            System.out.print("\n\n\t\t> ");
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                option = -1;
                e.printStackTrace();
            }
            switch (option) {
                case 0:
                    break;
                case 1:
                    System.out.println("\tDefinir HP(0-12)");
                    try {
                        a = sc.nextInt();
                    } catch (InputMismatchException e) {
                        option = -1;
                        e.printStackTrace();
                    }
                    if (a > 0 && a < 13) {
                        game.getState().selectHP(a);
                    } else {
                        System.out.println("Esse valor nao e possivel!");
                    }
                    break;
                case 2:
                    System.out.println("\tDefinir Hull(0-12)");
                    try {
                        a = sc.nextInt();
                    } catch (InputMismatchException e) {
                        option = -1;
                        e.printStackTrace();
                    }
                    if (a > 0 && a < 13) {
                        game.getState().selectHull(a);
                    } else {
                        System.out.println("Esse valor nao e possivel!");
                    }
                    break;
            }
        } while (option != 0);
    }

    public void uiAwaitBeginning() {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println();
            System.out.println("\t0 - Quit");
            System.out.println("\t1 - Opções");
            System.out.println("\t2 - Start");
            System.out.print("\n\n\t\t> ");
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                option = -1;
                e.printStackTrace();
            }
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    choseSettings();
                    break;
                case 2:
                    System.out.println("Comecou o jogo!!! COM " + game.getGameData().getSettings().getHp() + " HP e " + game.getGameData().getSettings().getHull() + " hull");

                    break;
                default:
                    System.out.println("\t Opcao invalida!!\n");
                    break;
            }
        } while (option == 0 && option == 2);

    }
}
