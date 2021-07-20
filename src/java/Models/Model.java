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
public class Model {
    private Long idModelo;
    private String NombreModelos;

    /**
     * @return the idModelo
     */
    public Long getIdModelo() {
        return idModelo;
    }

    /**
     * @param idModelo the idModelo to set
     */
    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * @return the NombreModelos
     */
    public String getNombreModelos() {
        return NombreModelos;
    }

    /**
     * @param NombreModelos the NombreModelos to set
     */
    public void setNombreModelos(String NombreModelos) {
        this.NombreModelos = NombreModelos;
    }
}
