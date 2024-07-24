package com.agencyglobalflights;

import java.sql.SQLException;

import com.agencyglobalflights.view.MainMenu;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        MainMenu mainmenu = new MainMenu();
        // se inicia el main menu
        mainmenu.Start();
    }
}