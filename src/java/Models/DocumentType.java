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
public enum DocumentType {

    TargetaIdentidad,
    Cedula;

    public String getDescription(DocumentType documentType) {

        String Description = "";
        if (documentType == TargetaIdentidad) {
            Description = "Tarjeta de identidad";
        } else if (documentType == Cedula) {
            Description = "Tarjeta de identidad";
        }
        return Description;
    }

    public int getType(DocumentType documentType) {

        int Description = 1;
        if (documentType == TargetaIdentidad) {
            Description = 1;
        } else if (documentType == Cedula) {
            Description = 2;
        }
        return Description;
    }

   

}
