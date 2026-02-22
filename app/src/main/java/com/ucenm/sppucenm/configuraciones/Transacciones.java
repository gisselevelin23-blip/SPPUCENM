package com.ucenm.sppucenm.configuraciones;

public class Transacciones
{
    public static final String DBNAME = "DBUSERS";
    public static final int DBVERSION = 1;
    public static final String TABLEUSERS = "usuarios";

    public static final String col_id = "id";
    public static final String col_nombres = "nombres";
    public static final String col_apellidos = "apellidos";
    public static final String col_edad = "edad";
    public static final String col_correo = "correo";

    public static final String CREATE_STMT = "CREATE TABLE "  + TABLEUSERS + " ( " +
            col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            col_nombres + " TEXT, " +
            col_apellidos + " TEXT, " +
            col_edad + " INTEGER , " +
            col_correo + " INTEGER ) " ;

    public static final String DROP_STMT = "DROP TABLE IF EXISTS " + TABLEUSERS;
    public static final String SELECT_STMT = "SELECT * FROM " + TABLEUSERS;


}
