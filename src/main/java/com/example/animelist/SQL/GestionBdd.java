//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.animelist.SQL;

import java.sql.*;

public class GestionBdd {
    public static final String TYPE_ODBC = "ODBC";
    public static final String TYPE_POSTGRES = "POSTGRES";
    public static final String TYPE_MYSQL = "MYSQL";

    public GestionBdd() {
    }

    public static Statement connexionBdd(String var0, String var1, String var2, String var3, String var4) {
        Statement var6 = null;

        try {
            String var5;
            Connection var7;
            if (var0.equals("ODBC")) {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                var5 = "jdbc:odbc:" + var1;
                var7 = DriverManager.getConnection(var5, var3, var4);
                var6 = var7.createStatement();
            } else if (var0.equals("MYSQL")) {
                Class.forName("org.mariadb.jdbc.Driver");
                var5 = "jdbc:mariadb://" + var2 + "/" + var1;
                var7 = DriverManager.getConnection(var5, var3, var4);
                var6 = var7.createStatement();
            }

            if (var0.equals("POSTGRES")) {
                Class.forName("org.postgresql.Driver");
                var5 = "jdbc:postgresql://" + var2 + "/" + var1 + "?user=" + var3 + "&password=" + var4;
                var7 = DriverManager.getConnection(var5);
                var6 = var7.createStatement();
            }
        } catch (ClassNotFoundException var8) {
            System.out.println("Driver non trouvÃ©");
        } catch (SQLException var9) {
            System.out.println("Erreur\n" + var9.getMessage());
            var9.printStackTrace();
        }

        return var6;
    }

    public static ResultSet envoiRequeteLMD(Statement var0, String var1) {
        ResultSet var2 = null;

        try {
            var2 = var0.executeQuery(var1);
        } catch (SQLException var4) {
            System.out.println("Erreur\n" + var4.getMessage());
            var4.printStackTrace();
        }

        return var2;
    }

    public static int envoiRequeteLID(Statement var0, String var1) {
        int var2 = 0;

        try {
            var2 = var0.executeUpdate(var1);
        } catch (SQLException var4) {
            System.out.println("Erreur\n" + var4.getMessage());
            var4.printStackTrace();
        }

        return var2;
    }
}
