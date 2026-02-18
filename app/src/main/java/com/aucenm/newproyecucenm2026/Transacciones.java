package com.aucenm.newproyecucenm2026;

public class Transacciones {
    public static final String CREATE_STMT = "";
    private static final String DBNAME = "DBUSERS";
    private static final int DBVERSION = 1;
    private static final String TABLEUSERS = "usuarios";
    private static final String col_id = "id";
    private static final String col_nombres = "nombres";
    private static final String col_apellidos = "apellidos";
    private static final String col_edad = "edad";
    private static final String col_correo = "correo";

    public static final String CREATE_STNT = "CREATE TABLE" + TABLEUSERS + "(" +
            col_id + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
            col_nombres + "TEXT," +
            col_apellidos + "TEXT," +
            col_edad + "INTEGER," +
            col_correo + "INTEGER )" ;

    public static final String DROP_STMT = "DROP TABLE IF EXISTS" + TABLEUSERS;
    private static final String SELECT_STM  = "SELECT * FROM" + TABLEUSERS;
}
