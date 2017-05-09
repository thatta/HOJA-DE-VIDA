/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoHojadeVida;

import javax.swing.Icon;

/**
 *
 * @Juan David Ojeda Bernal
 * @Tatiana Almansa
 */
public class Persona {
    
    private String nombre ;
    
    private Profesion profesion;
    
    private Genero genero;
    
    private EstadoCivil estado;
    
    private String documento ;
  
    private Icon Imagen;
   
    private String Correo;
    
    private String Apellido;
    
    private String Edad;
    
    private String Telefono;
   
    private String Direccion;

    public Persona(String nombre, Profesion profesion, Icon Imagen,String documento, Genero genero, String Correo, String Apellido, String Edad, String Telefono, EstadoCivil estado,String Direccion ) {
        this.nombre = nombre;
        this.profesion = profesion;
        this.Imagen = Imagen;
        this.documento = documento;
        this.genero = genero;
        this.Correo = Correo;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Telefono = Telefono;
        this.estado = estado;
        this.Direccion = Direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }    

    public Icon getImagen() {
        return Imagen;
    }

    public void setImagen(Icon Imagen) {
        this.Imagen = Imagen;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public EstadoCivil getEstado() {
        return estado;
    }

    public void setEstado(EstadoCivil estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
}
