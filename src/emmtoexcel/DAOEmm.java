/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emmtoexcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    private PreparedStatement statement;

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
            statement = connection.prepareStatement("select B.name_railway,C.name_cts,N.name_code_service_old,D.name_code_service_new, E.name_system ,"
                    + "F.system_full_name ,G.name_Arm ,A.key_word,I.name_group,L.name_time,J.name_group,M.name_time,"
                    + "O.name_template,H.name_group,T.name_priznak,P.name_AS_OZ,S.name_template,Q.name_AS_OZ,U.name_template,A.prim,A.reason "
                    + "FROM Main_Table A \n"
                    + "Left Join Railways B                on A.id_railway=B.id_railway "
                    + "Left Join Cts      C                 on C.id_cts=A.id_cts "
                    + "Left Join Code_services_old  N       on  N.id_code_service_old=A.id_code_service_old "
                    + "Left Join Code_services_new  D       on  D.id_code_service_new=A.id_code_service_new "
                    + "Left Join Systems E                  on  E.id_system=A.id_system "
                    + "Left Join Systems_full F             on  F.id_system_full=A.id_system_full "
                    + "Left Join ARM G                      on  G.id_ARM=A.id_ARM "
                    + "Left Join ESPP_groups I               on I.id_group=A.id_first_line_work_group "
                    + "Left Join Time L                       on L.id_time=A.id_first_line_work_time "
                    + "Left Join ESPP_groups J              on J.id_group=A.id_first_line_nonwork_group "
                    + "Left Join Time M                       on M.id_time=A.id_first_line_nonwork_time "
                    + "Left Join Templates O                   on O.id_template=A.id_template_web "
                    + "Left Join ESPP_groups H              on H.id_group=A.id_second_line_work_group "
                    + "Left Join Priznak T              on T.id_priznak=A.id_priznak "
                    + "Left Join AS_OZ P              on P.id_AS_OZ=A.id_AS_OZ_zapros "
                    + "Left Join Templates S              on S.id_template=A.id_template_zapros "
                    + "Left Join AS_OZ Q              on Q.id_AS_OZ=A.id_AS_OZ_naryad "
                    + "Left Join Templates U              on U.id_template=A.id_template_naryad "
                    + "where B.name_railway=?");
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmm.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public ResultSet getInfoByRw(String railWayName) throws SQLException {
        statement.clearParameters();
        statement.setString(1, railWayName);
        return statement.executeQuery();
    }

}
