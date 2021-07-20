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
public class State {
    private Long idEstado;
    private String NombreEstado;

    /**
     * @return the idEstado
     */
    public Long getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the NombreEstado
     */
    public String getNombreEstado() {
        return NombreEstado;
    }

    /**
     * @param NombreEstado the NombreEstado to set
     */
    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }
}
