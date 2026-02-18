package com.aucenm.newproyecucenm2026;

public class Usuarios {
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    private String correo;
    public Usuarios(){
    }

    public Usuarios(int id, String apellidos, String nombres, int edad, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.edad = edad;
        this.correo = correo;
    }
}
