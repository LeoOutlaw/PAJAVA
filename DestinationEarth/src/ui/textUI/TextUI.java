package ui.textUI;

import controllers.Game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * Aqui tera todas as funcoes de interfase (consola) com o utilizador
 * Em mais nenhuma parte do programa se vai fazer prints
 * Sempre que se quiser fazer um print teremos de chamar uma funcao daqui
 * Tudo o que e interacao com o utilizador e aqui que se faz
 * @author Leonardo
 */
public class TextUI {
    
    private Game game;
    
    public TextUI(Game game){
        this.game = game;
    }
    
    public void run(){
        System.out.println("O jogo comecou!!\n");
    }
}
