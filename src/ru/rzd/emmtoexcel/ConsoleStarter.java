/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.rzd.emmtoexcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.rzd.emmtoexcel.logic.EmmLogic;

/**
 *
 * @author ATonevitskiy
 */
public class ConsoleStarter {

    public static void main(String[] args) {
        System.out.println("opened");
        EmmLogic logic = new EmmLogic();
        try {
            logic.createFileWithData(new ArrayList<String>());
        } catch (EmmToExcelException | IOException ex) {
            System.err.println("ОШИБКА!");
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
