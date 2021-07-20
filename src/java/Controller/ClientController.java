/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Client;
import Util.MessageType;
import Util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class ClientController extends Util{

    ResultSet rs;
    Statement st;

    public ResultSet getRs() {
        return rs;
    }


    public Client getClientById(int id) {
        Client client = new Client();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from clientes where idClientes =" + id);
            if (rs != null) {
                while (rs.next()) {

                    client.setIdClientes(Long.parseLong(getAttributeStringByRs("idClientes")));
                    client.setNombres(getAttributeStringByRs("Nombres"));
                    client.setApellidos(getAttributeStringByRs("Apellidos"));
                    client.setNumeroDocumento(getAttributeStringByRs("NumeroDocumento"));
                    client.setCorreoElectronico(getAttributeStringByRs("CorreoElectronico"));
                                        
                    client.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    client.setDocumentType(client.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));

                }
            }

        } catch (Exception ex) {
            AddMessage(ex.getMessage(), MessageType.Error);
        }
        return client;
    }

    public List<Client> getClientList() {

        List<Client> clientList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM clientes ORDER BY idClientes DESC");
            if (getRs() != null) {
                while (getRs().next()) {
                    Client client = new Client();
                    client.setIdClientes(Long.parseLong(getAttributeStringByRs("idClientes")));
                    client.setNombres(getAttributeStringByRs("Nombres"));
                    client.setApellidos(getAttributeStringByRs("Apellidos"));
                    client.setNumeroDocumento(getAttributeStringByRs("NumeroDocumento"));
                    client.setCorreoElectronico(getAttributeStringByRs("CorreoElectronico"));
                                        
                    client.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    client.setDocumentType(client.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));

                    clientList.add(client);

                }
            }
        } catch (Exception ex) {
            AddMessage(ex.getMessage(), MessageType.Error);
        }
        return clientList;

    }

    public String getAttributeStringByRs(String name) {
        String Val = "";
        try {
            if (getRs() != null) {

                Val = getRs().getString(name);

            }
        } catch (Exception ex) {
            AddMessage(ex.getMessage(), MessageType.Error);
        }

        return Val;

    }
    
    
        public boolean getClientByEmailAdd(String email) {
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from clientes where CorreoElectronico = '"+email+"' ");
            if (rs != null) {
                while (rs.next()) {
                    return true;
                }
            }

        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }
        return false;
    }

    public boolean SaveClient(Client client) {
        PreparedStatement pst = null;
        String sentencia = "";
        try {
            //Si el objeto tiene id, entonces se ingresó al método para actualizar, de lo contrario creará un nuevo objeto en la base de datos
            if (client.getIdClientes() > 0) {
                sentencia = "update clientes set Nombres = '" + client.getNombres() + "', Apellidos = '" + client.getApellidos()+ "', NumeroDocumento = '" + client.getNumeroDocumento() + "', Telefono = '" + client.getTelefono() + "', CorreoElectronico = '" + client.getCorreoElectronico()+ "', Tipodedocmuento_idTipodedocmuento = "+ client.getDocumentType().getType(client.getDocumentType())+ " where idClientes = " + client.getIdClientes() + "";
                st = getConnection().createStatement();
                int g = st.executeUpdate(sentencia);
                if (g > 0) {
                    AddMessage("Se ha actualizado el cliente correctamente.", MessageType.Confirmation);
                    return true;
                }
            } else {
                sentencia = "insert into clientes (idClientes,Nombres,Apellidos,NumeroDocumento,CorreoElectronico,Telefono,Tipodedocmuento_idTipodedocmuento) values (?,?,?,?,?,?,?);";
                pst = getConnection().prepareStatement(sentencia);
                //Se envía el 0 por defecto teniendo en cuenta que el id  debe ser autoincrementable
                pst.setInt(1, 0);
                pst.setString(2, client.getNombres());
                pst.setString(3, client.getApellidos());
                pst.setString(4, client.getNumeroDocumento());
                
                pst.setString(5, client.getCorreoElectronico());
                pst.setLong(6, client.getTelefono());
                pst.setLong(7, client.getDocumentType().getType(client.getDocumentType()));

                if (pst.executeUpdate() == 1) {
                    AddMessage("Se ha añadido el cliente correctamente.", MessageType.Confirmation);
                    return true;
                }

            }
        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: "+ex.getMessage(), MessageType.Error);

        } 
        return false;

    }

}
