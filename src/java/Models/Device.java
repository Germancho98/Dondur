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
public class Device {
    private Long idDispositivos;
    private String IMEI;
    private Brand Brand;
    private Model Model;

    /**
     * @return the idDispositivos
     */
    public Long getIdDispositivos() {
        return idDispositivos;
    }

    /**
     * @param idDispositivos the idDispositivos to set
     */
    public void setIdDispositivos(Long idDispositivos) {
        this.idDispositivos = idDispositivos;
    }

    /**
     * @return the IMEI
     */
    public String getIMEI() {
        return IMEI;
    }

    /**
     * @param IMEI the IMEI to set
     */
    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    /**
     * @return the Brand
     */
    public Brand getBrand() {
        return Brand;
    }

    /**
     * @param Brand the Brand to set
     */
    public void setBrand(Brand Brand) {
        this.Brand = Brand;
    }

    /**
     * @return the Model
     */
    public Model getModel() {
        return Model;
    }

    /**
     * @param Model the Model to set
     */
    public void setModel(Model Model) {
        this.Model = Model;
    }
}
