/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Matthew
 */
public enum Rol {

    Administrador,
    Tecnico;

    public String getDescription(Rol rol) {

        String Description = "";
        if (rol == Administrador) {
            Description = "Administrador";
        } else if (rol == Tecnico) {
            Description = "Tecnico";
        }
        return Description;
    }

    public int getType(Rol rol) {

        int Description = 1;
        if (rol == Administrador) {
            Description = 1;
        } else if (rol == Tecnico) {
            Description = 2;
        }
        return Description;
    }

   
}
