/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Models.DocumentType.Cedula;
import static Models.DocumentType.TargetaIdentidad;
import static Models.Rol.Administrador;
import static Models.Rol.Tecnico;

/**
 *
 * @author Matthew
 */
public class UserEntity {

    private Long idUsuario;
    private String UserName;
    private String Pass;
    private String Nombre;
    private String Apellidos;
    private boolean Activo;
    private Long Telefono;
    private String Email;
    private String NoDocumento;
    private Rol Rol;
    private DocumentType DocumentType;

    /**
     * @return the idUsuario
     */
    public Long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellidos
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * @param Apellidos the Apellidos to set
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * @return the Activo
     */
    public boolean isActivo() {
        return Activo;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(boolean Activo) {
        this.Activo = Activo;
    }

    /**
     * @return the Telefono
     */
    public Long getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(Long Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the NoDocumento
     */
    public String getNoDocumento() {
        return NoDocumento;
    }

    /**
     * @param NoDocumento the NoDocumento to set
     */
    public void setNoDocumento(String NoDocumento) {
        this.NoDocumento = NoDocumento;
    }

    /**
     * @return the Rol
     */
    public Rol getRol() {
        return Rol;
    }

    /**
     * @param Rol the Rol to set
     */
    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    /**
     * @return the DocumentType
     */
    public DocumentType getDocumentType() {
        return DocumentType;
    }

    /**
     * @param DocumentType the DocumentType to set
     */
    public void setDocumentType(DocumentType DocumentType) {
        this.DocumentType = DocumentType;
    }

    public Rol getRol(int Type) {

        if (Type == 1) {
            return Administrador;
        } else if (Type == 2) {
            return Tecnico;
        }
        return Tecnico;
    }
    
    
     public DocumentType getDocumentType(int Type) {

        if (Type == 1) {
            return TargetaIdentidad;
        } else if (Type == 2) {

            return Cedula;
        }
        return Cedula;
    }

}
