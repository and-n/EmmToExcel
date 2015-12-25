/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmtoexcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ATonevitskiy
 */
public class DAOEmm {

    public DAOEmm() {
        connect();
    }

    private Connection connection;

    private void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOEmm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Нет драйвера базы!!!", null, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        // 10.58.1.96
        String connectionUrl1 = "jdbc:sqlserver://10.58.3.142;"
                + "databaseName=espp-search-test;user=iDilok;password=georgina;";
        try {
            connection = DriverManager.getConnection(connectionUrl1);
        } catch (SQLException ex) {
//            if (!Form.ISCONSOLE) {
//                Logger.getLogger(DAOOtchet.class.getName()).log(Level.SEVERE, null, ex);
//                int i = JOptionPane.showConfirmDialog(null, "Нет соединения с базой. Переподключиться?", "Database error", JOptionPane.YES_NO_OPTION);
//                if (i == JOptionPane.YES_OPTION) {
//                    connect();
//                } else {
//                    System.exit(1);
//                }
//            } else {
            System.out.println("Нет коннекта к базе! ");
            connect();
//            }
        }
    }

}
