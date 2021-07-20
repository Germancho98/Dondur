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
public class Brand {
    private Long idMarca;
    private String NombreMarcas;

    /**
     * @return the idMarca
     */
    public Long getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the NombreMarcas
     */
    public String getNombreMarcas() {
        return NombreMarcas;
    }

    /**
     * @param NombreMarcas the NombreMarcas to set
     */
    public void setNombreMarcas(String NombreMarcas) {
        this.NombreMarcas = NombreMarcas;
    }
}
