package ui.textUI;

import controllers.Game;
import controllers.stats.*;
import information.Members.Members;
import information.alien.Alien;
import information.rooms.ShipRooms;

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
            } else if (state instanceof SetupMembers) {
                setPlayersIntoRooms();
            } else if (state instanceof Turn) {
                advanceTurn();
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
            this.game.setState(new SetupMembers(game.getGameData()));
        }
    }

    private void setPlayersIntoRooms() {

        final List<Members> members = game.getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = game.getGameData().getShip().getRooms();

        //int userIndex = 0;
        
        for (int userIndex = 0; userIndex < members.size(); userIndex++) {

            int randomRoomNumber = new Random().nextInt(12) + 1;

            for (ShipRooms room : rooms) {
                if (room.getRoomNumber() == randomRoomNumber) {
                    room.setUser(members.get(userIndex));
                    
                    //userIndex= userIndex+1;
                    //members.remove(0);
                }
            }
        }

        this.game.setState(new Turn(game.getGameData()));

        System.out.println("Quartos: " + rooms);
        Scanner sc = new Scanner(System.in);
        sc.next();
    }

    private void advanceTurn() {
        game.getGameData().advanceTurn();
        final String journeyStep = game.getGameData().getJourneyStep();
        final List<ShipRooms> rooms = game.getGameData().getShip().getRooms();

        if (journeyStep.length() == 1) {
            //rest, start or end

            System.out.println("Step " + journeyStep);

            if (journeyStep.equals("R")) {
                System.out.println("Spend expiration points");
            } else if (journeyStep.equals("S")) {
                System.out.println("Start");
            } else {
                System.out.println("End game");

            }
        } else if (journeyStep.length() == 2) {
            assignAliens(journeyStep, rooms);
            crewPhase();

        } else {
            // assign aliens and put all aliens back to bowl in the end of turn
            assignAliens(journeyStep, rooms);

            //fase de batalha
            for (ShipRooms room : rooms) {
                room.deleteAllAliens();
            }

            System.out.println("outro turno");
        }

        System.out.println("Aliens: " + rooms);
        Scanner sc = new Scanner(System.in);
        sc.next();
    }

    private void assignAliens(final String journeyStep, final List<ShipRooms> rooms) throws NumberFormatException {
        // assign aliens
        int numberOfAliens = Integer.valueOf(journeyStep.split("A")[0]);

        System.out.println("number of aliens: " + numberOfAliens);

        for (int i = 0; i < numberOfAliens; i++) {
            final int roomNumber = game.getGameData().roll2Dice();

            for (ShipRooms room : rooms) { // corre as salas todas. pode ser melhorado para saltar fora antes
                if (room.getRoomNumber() == roomNumber) {
                    room.addAlien(new Alien());
                }
            }
        }
    }

    private void crewPhase() {
        int actionPoints = 5;

        final List<Members> members = game.getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = game.getGameData().getShip().getRooms();

        //for (Members membro : members)
        System.out.println();
        System.out.println("\t You have " + actionPoints + " action points: ");
        System.out.println("\t0 - Move (1AP)");
        System.out.println("\t1 - Attack (1AP)");
        System.out.println("\t2 - Heal one health [Doctor only] (1 AP) ");
        System.out.println("\t3 - Fix one Hull [Engineer Only] (1AP)");
        System.out.println("\t4 - Setting Trap (1AP)");
        System.out.println("\t5 - Seal Room (1AP)");
        System.out.println("\t6 - do nothing");
        System.out.print("\n\n\t\t> ");

        Scanner sc = new Scanner(System.in);

        final int action = sc.nextInt();

        do {
            switch (action) {
                case 0: // move
                    moveMember(members.get(0), rooms);
                    break;
                case 1:// attack
                    game.getState().chooseMember(action);
                    break;
                case 2:// heal health
                    game.getState().chooseMember(action);
                    break;
                case 3:// heal hull
                    game.getState().chooseMember(action);
                    break;
                case 4:// setting trap
                    game.getState().chooseMember(action);
                    break;
                case 5:// Seal room
                    game.getState().chooseMember(action);
                    break;
                default:
                    System.out.println("\t Opcao invalida!!\n");
                    break;
            }
        } while (action < 0 && action > 12);

    }
    
    private void moveMember(Members get, List<ShipRooms> rooms) {
        for (ShipRooms room : rooms) {
            if(room.getUser().contains(get)){
                System.out.println("Room " + room.getName() + " has these neighbours: ");
                System.out.println(room.getNeighbours());
                
                // pede ao utilizador para fornecer o numero da sala vizinha e atribui o membero em causa para la e remove da sala actual.
                // decrementa action point
       
            }
        }
    }
}
