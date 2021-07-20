/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Repair;
import Util.MessageType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class RepairController extends Util.Util {

    ResultSet rs;
    Statement st;
    DeviceController deviceController = new DeviceController();
    StateController stateController = new StateController();
    UserController userController = new UserController();
    ClientController clientController = new ClientController();

    public ResultSet getRs() {
        return rs;
    }

    public Repair getRepairById(Long id) {
        Repair repair = new Repair();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from reparaciones where idReparaciones =" + id);
            if (rs != null) {
                while (rs.next()) {
                    repair.setIdReparaciones(Long.parseLong(getAttributeStringByRs("idReparaciones")));
                    repair.setDescripcion(getAttributeStringByRs("Descripcion"));
                    repair.setFechaEntrega(getAttributeStringByRs("FechaEntrega"));
                    repair.setPrecio(getAttributeStringByRs("Precio"));
                    repair.setClient(clientController.getClientById(Integer.parseInt(getAttributeStringByRs("Clientes_idClientes"))));
                    repair.setDevice(deviceController.getDeviceById(Long.parseLong(getAttributeStringByRs("Dispositivos_idDispositivos"))));
                    repair.setUserEntity(userController.getUserById(Long.parseLong(getAttributeStringByRs("Usuarios_idUsuarios"))));
                    repair.setState(stateController.getStateById(Long.parseLong(getAttributeStringByRs("Estado_idEstado"))));
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return repair;
    }

    public List<Repair> getRepairList() {
        List<Repair> repairList = new ArrayList();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from reparaciones ORDER BY idReparaciones DESC ");
            if (rs != null) {
                while (rs.next()) {
                    Repair repair = new Repair();
                    repair.setIdReparaciones(Long.parseLong(getAttributeStringByRs("idReparaciones")));
                    repair.setDescripcion(getAttributeStringByRs("Descripcion"));
                    repair.setFechaEntrega(getAttributeStringByRs("FechaEntrega"));
                    repair.setPrecio(getAttributeStringByRs("Precio"));
                    repair.setClient(clientController.getClientById(Integer.parseInt(getAttributeStringByRs("Clientes_idClientes"))));
                    repair.setDevice(deviceController.getDeviceById(Long.parseLong(getAttributeStringByRs("Dispositivos_idDispositivos"))));
                    repair.setUserEntity(userController.getUserById(Long.parseLong(getAttributeStringByRs("Usuarios_idUsuarios"))));
                    repair.setState(stateController.getStateById(Long.parseLong(getAttributeStringByRs("Estado_idEstado"))));
                    repairList.add(repair);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return repairList;
    }
    
    
    public List<Repair> getRepairListByClient(Long Document) {
        List<Repair> repairList = new ArrayList();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select t1.* from reparaciones t1 inner join clientes t2 on t1.Clientes_idClientes = t2.idClientes where t2.NumeroDocumento = '"+Document+"'  ORDER BY t1.idReparaciones DESC ");
            if (rs != null) {
                while (rs.next()) {
                    Repair repair = new Repair();
                    repair.setIdReparaciones(Long.parseLong(getAttributeStringByRs("idReparaciones")));
                    repair.setDescripcion(getAttributeStringByRs("Descripcion"));
                    repair.setFechaEntrega(getAttributeStringByRs("FechaEntrega"));
                    repair.setPrecio(getAttributeStringByRs("Precio"));
                    repair.setClient(clientController.getClientById(Integer.parseInt(getAttributeStringByRs("Clientes_idClientes"))));
                    repair.setDevice(deviceController.getDeviceById(Long.parseLong(getAttributeStringByRs("Dispositivos_idDispositivos"))));
                    repair.setUserEntity(userController.getUserById(Long.parseLong(getAttributeStringByRs("Usuarios_idUsuarios"))));
                    repair.setState(stateController.getStateById(Long.parseLong(getAttributeStringByRs("Estado_idEstado"))));
                    repairList.add(repair);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return repairList;
    }

    public String getAttributeStringByRs(String name) {
        String Val = "";
        try {
            if (getRs() != null) {

                Val = getRs().getString(name);

            }
        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }

        return Val;

    }

    public boolean SaveRepair(Repair repair) {
        PreparedStatement pst = null;
        String sentencia = "";
        try {
            if (repair.getIdReparaciones() > 0) {
                sentencia = "update reparaciones set Descripcion = '" + repair.getDescripcion() + "', Precio = '" + repair.getPrecio() + "', FechaEntrega = '" + repair.getFechaEntrega() + "', Estado_idEstado = " + repair.getState().getIdEstado() + ", Clientes_idClientes = " + repair.getClient().getIdClientes() + ", Dispositivos_idDispositivos = " + repair.getDevice().getIdDispositivos() + ", Usuarios_idUsuarios = " + repair.getUserEntity().getIdUsuario() + " where idReparaciones = " + repair.getIdReparaciones() + "";
                st = getConnection().createStatement();
                int g = st.executeUpdate(sentencia);
                if (g > 0) {
                    AddMessage("Se ha actualizado la solicitud de reparación correctamente.", MessageType.Confirmation);
                    return true;
                }
            } else {
                sentencia = "insert into reparaciones (idReparaciones,Descripcion,Precio,FechaEntrega,Estado_idEstado,Clientes_idClientes,Dispositivos_idDispositivos,Usuarios_idUsuarios) values (?,?,?,?,?,?,?,?);";
                pst = getConnection().prepareStatement(sentencia);
                pst.setLong(1, repair.getIdReparaciones());
                pst.setString(2, repair.getDescripcion());
                pst.setString(3, repair.getPrecio());
                pst.setString(4, repair.getFechaEntrega());
                pst.setLong(5, repair.getState().getIdEstado());
                pst.setLong(6, repair.getClient().getIdClientes());
                pst.setLong(7, repair.getDevice().getIdDispositivos());
                pst.setLong(8, repair.getUserEntity().getIdUsuario());
                if (pst.executeUpdate() == 1) {
                    AddMessage("Se ha añadido la solicitud de reparación correctamente.", MessageType.Confirmation);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

}
