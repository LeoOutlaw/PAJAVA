package ui.textUI;

import controllers.Game;
import controllers.stats.*;
import information.rooms.Bridge;
import information.rooms.ConferenceRoom;
import information.rooms.MessHall;
import information.rooms.ShipRooms;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
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
            System.out.println("state: " + state);

            if (state instanceof AwaitBeginning) {
                uiAwaitBeginning();
            } else if (state instanceof AwaitNewCrewMember) {
                uiAwaitNewCrewMember();
            } else if (state instanceof StartGame) {
                chupameapila();
            }
        }
    }

    public void choseSettings() {
        Scanner sc = new Scanner(System.in);
        int option;
        int a = 0;

        do {
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
                    game.startGame();
                    break;
                default:
                    System.out.println("\t Opcao invalida!!\n");
                    break;
            }
        } while (option == 0 && option == 2);

    }

    private void uiAwaitNewCrewMember() {
        Scanner sc = new Scanner(System.in);
        int option;

        System.out.println();
        System.out.println("\tDiga o crew member que pretende escolher: ");
        System.out.println("\t0 - Sair");
        System.out.println("\t1 - Doctor");
        System.out.println("\t2 - Captain");
        System.out.println("\t3 - Commander");
        System.out.println("\t4 - Comms Officer");
        System.out.println("\t5 - Enginer");
        System.out.println("\t6 - Moral Officer");
        System.out.println("\t7 - Navigation Officer");
        System.out.println("\t8 - Red Shirt");
        System.out.println("\t9 - Science Officer");
        System.out.println("\t10 - Security Officer");
        System.out.println("\t11 - Shuttle Pilot");
        System.out.println("\t12 - Transporter Chief");
        System.out.print("\n\n\t\t> ");
        do {
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
                    game.getState().chooseMember(option);
                    break;
                case 2:
                    game.getState().chooseMember(option);
                    break;
                default:
                    System.out.println("\t Opcao invalida!!\n");
                    break;
            }
        } while (option < 0 && option > 12);
        if (game.getGameData().getPlayer().getMembers().size() == 2) {
            this.game.setState(new StartGame(game.getGameData()));
        }
    }

    private void chupameapila() {

        System.out.println("number of players: " +  game.getGameData().getPlayer().getMembers().size());
        
     ShipRooms bridge = game.getGameData().getShip().getBridge();
             ShipRooms conferenceRoom = game.getGameData().getShip().getConferenceRoom();
     ShipRooms messHall = game.getGameData().getShip().getMessHall();

        Random r = new Random();

        int randomRoomNumber = r.nextInt(7) + 1;

        if (randomRoomNumber == 1 || randomRoomNumber == 8 || randomRoomNumber == 5) {

            List<ShipRooms> rooms = Arrays.asList(bridge, conferenceRoom, messHall);
            
            for (ShipRooms room : rooms) {
                if (room.getRoomNumber() == randomRoomNumber && room.getUser() == null) {
                    room.setUser(game.getGameData().getPlayer().getMembers().get(0));
                    game.getGameData().getPlayer().getMembers().remove(0);
                }
            }
            
            
            System.out.println("Quartos: " + rooms);
        Scanner sc = new Scanner(System.in);
        sc.next();

            
        }
    }
}
