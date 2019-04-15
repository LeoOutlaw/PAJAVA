/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 * Esta classe vai ter o GameData do jogo e 
 * saber em que estado do jogo estamos
 * Classe superior a GameData e da maquina de estados
 * para que se consiga Ligar a maquina de estados a informaçao do jogo
 * @author Leonardo
 */
public class Game {
    
    private GameData gameData;
    
    public Game(){
        gameData = new GameData();
        
    }
    
}
