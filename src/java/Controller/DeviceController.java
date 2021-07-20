/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Device;
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
public class DeviceController extends Util.Util {

    ResultSet rs;
    Statement st;
    ModelController modelController = new ModelController();
    BrandController brandController = new BrandController();

    public ResultSet getRs() {
        return rs;
    }

    public Device getDeviceById(Long id) {
        Device device = new Device();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from dispositivos where idDispositivos =" + id);
            if (rs != null) {
                while (rs.next()) {
                    device.setIdDispositivos(Long.parseLong(getAttributeStringByRs("idDispositivos")));
                    device.setIMEI(getAttributeStringByRs("IMEI"));
                    device.setBrand(brandController.getBrandById(Long.parseLong(getAttributeStringByRs("Marca_idMarca"))));
                    device.setModel(modelController.getModelById(Long.parseLong(getAttributeStringByRs("Modelo_idModelo"))));
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return device;
    }

    public List<Device> getDeviceList() {
        List<Device> deviceList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from dispositivos ORDER BY idDispositivos DESC");
            if (rs != null) {
                while (rs.next()) {
                    Device device = new Device();
                    device.setIdDispositivos(Long.parseLong(getAttributeStringByRs("idDispositivos")));
                    device.setIMEI(getAttributeStringByRs("IMEI"));
                    device.setBrand(brandController.getBrandById(Long.parseLong(getAttributeStringByRs("Marca_idMarca"))));
                    device.setModel(modelController.getModelById(Long.parseLong(getAttributeStringByRs("Modelo_idModelo"))));
                    deviceList.add(device);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return deviceList;
    }
    
    
        public List<Device> getDeviceList2() {
        List<Device> deviceList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from dispositivos WHERE idDispositivos NOT IN (SELECT Dispositivos_idDispositivos FROM reparaciones) ORDER BY idDispositivos DESC");
            if (rs != null) {
                while (rs.next()) {
                    Device device = new Device();
                    device.setIdDispositivos(Long.parseLong(getAttributeStringByRs("idDispositivos")));
                    device.setIMEI(getAttributeStringByRs("IMEI"));
                    device.setBrand(brandController.getBrandById(Long.parseLong(getAttributeStringByRs("Marca_idMarca"))));
                    device.setModel(modelController.getModelById(Long.parseLong(getAttributeStringByRs("Modelo_idModelo"))));
                    deviceList.add(device);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return deviceList;
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

    public boolean SaveDevice(Device device) {
        PreparedStatement pst = null;
        String sentencia = "";
        try {
            if (device.getIdDispositivos() > 0) {
                sentencia = "update dispositivos set IMEI = '" + device.getIMEI() + "', Modelo_idModelo = " + device.getModel().getIdModelo() + ", Marca_idMarca = " + device.getBrand().getIdMarca() + " where idDispositivos = " + device.getIdDispositivos();
                st = getConnection().createStatement();
                int g = st.executeUpdate(sentencia);
                if (g > 0) {
                    AddMessage("Se ha actualizado el dispositivo correctamente.", MessageType.Confirmation);
                    return true;
                }
            } else {
                sentencia = "insert into dispositivos (idDispositivos,IMEI,Modelo_idModelo,Marca_idMarca) values (?,?,?,?);";
                pst = getConnection().prepareStatement(sentencia);
                pst.setInt(1, 0);
                pst.setString(2, device.getIMEI());
                pst.setLong(3, device.getModel().getIdModelo());
                pst.setLong(4, device.getBrand().getIdMarca());
                
                if (pst.executeUpdate() == 1) {
                    AddMessage("Se ha añadido el equipo correctamente.", MessageType.Confirmation);
                    return true;
                }

            }
        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return false;
    }
}
