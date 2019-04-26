package ui.textUI;

import controllers.Game;

import java.util.Scanner;

/**
 *
 * @author Leonardo
 */
public class MenuTextUI {
    
    private TextUI textUI;
    
    public MenuTextUI(){
        Scanner sc = new Scanner (System.in);
        int i = 1;
        
        System.out.println("\t 1. Novo Jogo");
        System.out.println("\t 2. Carregar Jogo");
        System.out.println("\t 3. Sair");
 
        System.out.print("\n\n\t\t> ");
        
        do{
            i = sc.nextInt();
            
            switch(i){
                case 1:
                    textUI = new TextUI(new Game());
                    textUI.run();
                    break;
                case 2:
                   // textUI = new TextUI(new Game());
                    textUI.load();
                    //Após ler como colocar logo no estado seguinte?
                    break;
                case 3:
                    System.out.println("\t Sair\n");
                    break;
                default:
                    System.out.println("\t Opcao invalidada!!\n");
                    i = -1;
                    break;
            }
        }while(i == -1);
    }
}
