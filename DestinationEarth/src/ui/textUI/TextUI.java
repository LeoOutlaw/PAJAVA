package ui.textUI;

import controllers.Game;
import controllers.stats.*;
import information.Members.Members;
import information.alien.Alien;
import information.rooms.ShipRooms;

import java.util.Arrays;
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
            } else if (state instanceof AwaitNewCrewMember) {
                uiAwaitNewCrewMember();
            } else if (state instanceof SetupMembers) {
                setPlayersIntoRooms();
            } else if (state instanceof Turn) {
                advanceTurn();
            } else if (state instanceof AwaitAlliensPlacement) {
                uiAwaitAlliensPlacement();
            } else if (state instanceof AwaitRestPhase) {
                uiAwaitRestPhase();
            } else if (state instanceof AwaitCrewPhase) {
                uiAwaitCrewPhase();
            } else if (state instanceof AwaitAlienPhase) {
                uiAwaitAlienPhase();
            } else if (state instanceof FinalStage) {
                uiFinalStage();
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
        System.out.println("\t5 - Engineer");
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
                    game.chooseMember(option);
                    break;
                case 2:
                    game.chooseMember(option);
                    break;
                case 3:
                    game.chooseMember(option);
                    break;
                case 4:
                    game.chooseMember(option);
                    break;
                case 5:
                    game.chooseMember(option);
                    break;
                case 6:
                    game.chooseMember(option);
                    break;
                case 7:
                    game.chooseMember(option);
                    break;
                case 8:
                    game.chooseMember(option);
                    break;
                case 9:
                    game.chooseMember(option);
                    break;
                case 10:
                    game.chooseMember(option);
                    break;
                case 11:
                    game.chooseMember(option);
                    break;
                case 12:
                    game.chooseMember(option);
                    break;
                default:
                    System.out.println("\t Opcao invalida!!\n");
                    break;
            }
        } while (option < 0 && option > 12);
    }

    private void setPlayersIntoRooms() {
        game.valActionPoints();
        game.setRoomsPlayers();

        //this.game.setState(new Turn(game.getGameData()));
        for (int i = 0; i < game.getGameData().getShip().getRooms().size(); i++) {
            System.out.println("Quartos : " + game.getGameData().getShip().getRooms().get(i).getUser());
        }

    }

    private void advanceTurn() {

        final String journeyStep = game.getGameData().getJourneyStep();
        System.out.println("HP: " + game.getGameData().getPlayer().getHp());
        System.out.println("HULL: " + game.getGameData().getShip().getHull());
        System.out.println("Turn: " + game.getGameData().getJourneyStep());

        if (journeyStep.length() == 1) {
            //rest, start or end

            if (journeyStep.equals("R")) {
                System.out.println("Spend expiration points");
                game.journeyTracker(journeyStep.length());
            } else if (journeyStep.equals("S")) {
                System.out.println("Start");
                game.getGameData().advanceTurn();
            } else {
                System.out.println("End game");
                game.winGame();
            }
        } else if (journeyStep.length() == 2) {
            game.journeyTracker(journeyStep.length());
        } else {
            // assign aliens and put all aliens back to bowl in the end of turn
            game.journeyTracker(journeyStep.length()); // Ver se o proximo turn e REST e apager todos os alliens
            //fase de batalha
        }

    }

    /*  private void assignAliens(final String journeyStep, final List<ShipRooms> rooms) throws NumberFormatException {
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
    }*/
    private void uiAwaitCrewPhase() {
        int aux;
        boolean ex = false;

        final List<Members> members = game.getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = game.getGameData().getShip().getRooms();
        while (game.getGameData().getActionPoints() != 0) {
            //for (Members membro : members)
            System.out.println(game.getGameData().getJourneyStep());
            System.out.println();
            System.out.println("\t You have " + game.getGameData().getActionPoints() + " action points: ");
            System.out.println("\t0 - Return");
            System.out.println("\t1 - Move (1AP)");
            System.out.println("\t2 - Attack (1AP)");
            System.out.println("\t3 - Heal one health [Doctor only] (1AP) ");
            System.out.println("\t4 - Fix one Hull [Engineer Only] (1AP)");
            System.out.println("\t5 - Setting Organic Detonator Trap (1AP)");
            System.out.println("\t6 - Setting Particle Disperser Trap (1AP)");
            System.out.println("\t7 - Seal Room (1AP)");
            System.out.print("\n\n\t\t> ");

            Scanner sc = new Scanner(System.in);

            final int action = sc.nextInt();

            do {
                switch (action) {
                    case 0:
                        break;
                    case 1:
                        do {
                            System.out.println("What member do you want to move?");
                            for (int i = 0; i < members.size(); i++) {
                                System.out.println("\t" + (i + 1) + " - " + members.get(i).getName());
                            }
                            System.out.print("\n\n\t\t> ");
                            aux = sc.nextInt();
                        } while (aux < 1 && aux > 2);
                        moveMember(members.get(aux - 1), rooms);
                        game.getGameData().decementActionPoints();
                        break;
                    case 2:// heal health
                        game.getState().chooseMember(action);
                        break;
                    case 3:
                        for (int i = 0; i < game.getGameData().getPlayer().getMembers().size(); i++) {
                            if (game.getGameData().getPlayer().getMembers().get(i).getName().equals("Doctor")) {
                                game.getGameData().getPlayer().setHp(game.getGameData().getPlayer().getHp() + 1);
                                System.out.println("O player tem mais um de HP!");
                                ex = true;
                                break;
                            }
                        }
                        if (ex == true) {
                            ex = false;
                            break;
                        } else {
                            System.out.println("O player nao na sua crew o Doctor!");
                            break;
                        }
                    case 4:
                        for (int i = 0; i < game.getGameData().getPlayer().getMembers().size(); i++) {
                            if (game.getGameData().getPlayer().getMembers().get(i).getName().equals("Engineer")) {
                                game.getGameData().getShip().setHull(game.getGameData().getShip().getHull() + 1);
                                System.out.println("O ship tem mais um de HULL!");
                                ex = true;
                                break;
                            }
                        }
                        if (ex == true) {
                            ex = false;
                            break;
                        } else {
                            System.out.println("O player nao na sua crew o Enginner!");
                            break;
                        }
                    case 5:
                        if (game.getGameData().getOrganicDetonator() > 0) {
                            do {
                                System.out.println("Onde deseja por o Organic Detonator");
                                for (int i = 0; i < game.getGameData().getShip().getRooms().size(); i++) {
                                    if (!game.getGameData().getShip().getRooms().get(i).getUser().isEmpty()) {
                                        System.out.println("\t" + (i + 1) + ": " + game.getGameData().getShip().getRooms().get(i).getName());
                                    }
                                }
                                System.out.print("\n\n\t\t> ");
                                aux = sc.nextInt();
                            } while (aux < 1 && aux > 2);
                            game.getGameData().decementActionPoints();
                            game.getGameData().getShip().getRooms().get(aux - 1).setOrganicDetonator();
                            game.getGameData().setOrganicDetonator(game.getGameData().getOrganicDetonator() - 1);
                        } else {
                            System.out.println("Nao tem mais Organic Detonator!");
                        }
                        break;
                    case 6:
                        if (game.getGameData().getParticleDisperser() > 0) {
                            do {
                                System.out.println("Onde deseja por o Particle Disperner?");
                                for (int i = 0; i < game.getGameData().getShip().getRooms().size(); i++) {
                                    if (!game.getGameData().getShip().getRooms().get(i).getUser().isEmpty()) {
                                        System.out.println("\t" + (i + 1) + ": " + game.getGameData().getShip().getRooms().get(i).getName());
                                    }
                                }
                                System.out.print("\n\n\t\t> ");
                                aux = sc.nextInt();
                            } while (aux < 1 && aux > 2);
                            game.getGameData().decementActionPoints();
                            game.getGameData().getShip().getRooms().get(aux - 1).setParticleDisperser();
                            game.getGameData().setParticleDisperser(game.getGameData().getParticleDisperser() - 1);
                        } else {
                            System.out.println("Nao tem mais Particle Disperser!");
                        }
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("\t Opcao invalida!!\n");
                        break;
                }
            } while (action < 0 && action > 6);
            if (action == 0) {
                game.dontDoNothing();
                break;
            }
        }
        game.dontDoNothing();
    }

    private void moveMember(Members get, List<ShipRooms> rooms) {
        int option;
        Scanner sc = new Scanner(System.in);
        for (ShipRooms room : rooms) {
            if (room.getUser().contains(get)) {
                System.out.println("Room " + room.getName() + " has these neighbours: ");
                for (int i = 0; i < room.getNeighbours().size(); i++) {
                    System.out.println("\t" + (i + 1) + " - " + room.getNeighbours().get(i).getName());
                }
                System.out.print("\n\n\t\t>");
                option = sc.nextInt();
                if (room.getName().equals("NavigationOfficer")) {
                    //fazer alguma coisa!!(nao me lembro)
                }
                room.removeUser(get);
                room.getNeighbours().get(option - 1).setUser(get);

                for (int i = 0; i < game.getGameData().getShip().getRooms().size(); i++) {
                    System.out.println("Quartos : " + game.getGameData().getShip().getRooms().get(i).getUser());
                }
                break;
            }
        }
    }

    public void uiAwaitRestPhase() {
        game.clearAliens();
        int aux;

        while (game.getGameData().getPlayer().getInspirationPoints() != 0) {
            //for (Members membro : members)
            System.out.println(game.getGameData().getJourneyStep());
            System.out.println();
            System.out.println("\t You have " + game.getGameData().getPlayer().getInspirationPoints() + " action points: ");
            System.out.println("\t0 - Return");
            System.out.println("\t1 - Add one to Healt (1 IP)");
            System.out.println("\t2 - Repair one Hull (1 IP) ");
            System.out.println("\t3 - Build one Organic Detonator (2 IP)");
            System.out.println("\t4 - Add one to Movement (4 IP)");
            System.out.println("\t5 - Build one Particle Desperser (5 IP)");
            System.out.println("\t6 - Gain one Sealed Room Token (5 IP)");
            System.out.println("\t7 - Gain one extra Attack Die (6 IP)");
            System.out.println("\t6 - Add one to the result of an Attack Dice (6 IP)");
            System.out.print("\n\n\t\t> ");

            Scanner sc = new Scanner(System.in);

            final int action = sc.nextInt();

            do {
                switch (action) {
                    case 0:
                        break;
                    case 1:
                        game.getGameData().getPlayer().setHp(game.getGameData().getPlayer().getHp() + 1);
                        System.out.println("O player tem mais um de HP!");
                        break;
                    case 2:
                        game.getGameData().getShip().setHull(game.getGameData().getShip().getHull() + 1);
                        System.out.println("O ship tem mais um de HULL!");
                        break;
                    case 3:
                        if (game.getGameData().getPlayer().getInspirationPoints() > 1) {
                            game.getGameData().setOrganicDetonator(game.getGameData().getOrganicDetonator() + 1);
                            System.out.println("Um Organic Detonator foi construido!");
                        } else {
                            System.out.println("Nao tem Inspiration Poins suficientes");
                        }
                        break;
                    case 4:
                        game.getState().chooseMember(action);
                        break;
                    case 5:
                        if (game.getGameData().getPlayer().getInspirationPoints() > 4) {
                            game.getGameData().setParticleDisperser(game.getGameData().getParticleDisperser() + 1);
                            System.out.println("Um Particle Disperser foi construido!");
                        } else {
                            System.out.println("Nao tem Inspiration Poins suficientes");
                        }
                        break;
                    case 6:
                        if (game.getGameData().getPlayer().getInspirationPoints() > 4) {
                            game.getGameData().setSealedRoom(game.getGameData().getSealedRoom() + 1);
                            System.out.println("Um tocken Sealed Room foi criado!");
                        } else {
                            System.out.println("Nao tem Inspiration Poins suficientes");
                        }
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("\t Opcao invalida!!\n");
                        break;
                }
            } while (action < 0 && action > 8);
        }
        game.endOfRestPhase();
    }

    public void uiAwaitAlliensPlacement() {
        final String journeyStep = game.getGameData().getJourneyStep();

        int numberOfAliens = Integer.valueOf(journeyStep.split("A")[0]);
        System.out.println("number of aliens: " + numberOfAliens);
        game.assignAliens(numberOfAliens);

        for (int i = 0; i < game.getGameData().getShip().getRooms().size(); i++) {
            System.out.println("Alliens : " + game.getGameData().getShip().getRooms().get(i).getAliens());
        }
        //Ver se o proximo turno e REST!!!
    }

    private void uiAwaitAlienPhase() {
        game.moveAliensRandom();
        game.combatAliens();
        System.out.println("TEM " + game.getGameData().getPlayer().getHp() + " HP e " + game.getGameData().getShip().getHull() + " hull");
    }

    private void uiFinalStage() {
        game.endGame();
    }
}
