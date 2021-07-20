/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Models.DocumentType.Cedula;
import static Models.DocumentType.TargetaIdentidad;

/**
 *
 * @author Matthew
 */
public class Client {

    private Long idClientes;
    private String Nombres;
    private String Apellidos;
    private String NumeroDocumento;
    private String CorreoElectronico;
    private Long Telefono;
    private DocumentType DocumentType;

    public DocumentType getDocumentType(int Type) {

        if (Type == 1) {
            return TargetaIdentidad;
        } else if (Type == 2) {

            return Cedula;
        }
        return Cedula;
    }

    /**
     * @return the idClientes
     */
    public Long getIdClientes() {
        return idClientes;
    }

    /**
     * @param idClientes the idClientes to set
     */
    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    /**
     * @return the Nombres
     */
    public String getNombres() {
        return Nombres;
    }

    /**
     * @param Nombres the Nombres to set
     */
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
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
     * @return the NumeroDocumento
     */
    public String getNumeroDocumento() {
        return NumeroDocumento;
    }

    /**
     * @param NumeroDocumento the NumeroDocumento to set
     */
    public void setNumeroDocumento(String NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    /**
     * @return the CorreoElectronico
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     * @param CorreoElectronico the CorreoElectronico to set
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
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
}
