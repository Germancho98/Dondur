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
public class Repair {
    private Long idReparaciones;
    private String Descripcion;
    private String Precio;
    private String FechaEntrega;
    private State State;
    private Client Client;
    private Device Device;
    private UserEntity UserEntity;

    /**
     * @return the idReparaciones
     */
    public Long getIdReparaciones() {
        return idReparaciones;
    }

    /**
     * @param idReparaciones the idReparaciones to set
     */
    public void setIdReparaciones(Long idReparaciones) {
        this.idReparaciones = idReparaciones;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Precio
     */
    public String getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the FechaEntrega
     */
    public String getFechaEntrega() {
        return FechaEntrega;
    }

    /**
     * @param FechaEntrega the FechaEntrega to set
     */
    public void setFechaEntrega(String FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    /**
     * @return the State
     */
    public State getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(State State) {
        this.State = State;
    }

    /**
     * @return the Client
     */
    public Client getClient() {
        return Client;
    }

    /**
     * @param Client the Client to set
     */
    public void setClient(Client Client) {
        this.Client = Client;
    }

    /**
     * @return the Device
     */
    public Device getDevice() {
        return Device;
    }

    /**
     * @param Device the Device to set
     */
    public void setDevice(Device Device) {
        this.Device = Device;
    }

    /**
     * @return the UserEntity
     */
    public UserEntity getUserEntity() {
        return UserEntity;
    }

    /**
     * @param UserEntity the UserEntity to set
     */
    public void setUserEntity(UserEntity UserEntity) {
        this.UserEntity = UserEntity;
    }
    
}
