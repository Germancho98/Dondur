/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.DocumentType;
import Models.Rol;
import Models.UserEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Util.MessageType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class UserController extends Util.Util {

    ResultSet rs;
    Statement st;

    public ResultSet getRs() {
        return rs;
    }

    public boolean SaveUser(UserEntity userEntity) {
        PreparedStatement pst = null;
        String sentencia = "";
        try {
            int State = 0;
            if (userEntity.isActivo()) {
                State = 1;
            }
            //Si el objeto tiene id, entonces se ingresó al método para actualizar, de lo contrario creará un nuevo objeto en la base de datos
            if (userEntity.getIdUsuario() > 0) {

                sentencia = "update usuarios set NombreUsuario = '" + userEntity.getUserName() + "', Contraseña = '" + userEntity.getPass() + "', Nombre = '" + userEntity.getNombre() + "', Apellidos = '" + userEntity.getApellidos() + "', Activo = " + State + ", Telefono = " + userEntity.getTelefono() + ", CorreoElectronico = '" + userEntity.getEmail() + "', NumeroDocumento = '" + userEntity.getNoDocumento() + "', Rol_idRol = " + userEntity.getRol().getType(userEntity.getRol()) + ", Tipodedocmuento_idTipodedocmuento =" + userEntity.getDocumentType().getType(userEntity.getDocumentType()) + " where idUsuarios = " + userEntity.getIdUsuario() + "";
                st = getConnection().createStatement();
                int g = st.executeUpdate(sentencia);
                if (g > 0) {
                    if (!userEntity.isActivo()) {
                        AddMessage("Se ha eliminado el usuario correctamente.", MessageType.Confirmation);
                    } else {
                        AddMessage("Se ha actualizado el usuario correctamente.", MessageType.Confirmation);
                    }

                    return true;
                }
            } else {
                sentencia = "insert into usuarios (idUsuarios,NombreUsuario,Contraseña,Nombre,Apellidos,Activo,Telefono,CorreoElectronico,NumeroDocumento,Rol_idRol,Tipodedocmuento_idTipodedocmuento) values (?,?,?,?,?,?,?,?,?,?,?);";
                pst = getConnection().prepareStatement(sentencia);
                //Se envía el 0 por defecto teniendo en cuenta que el id  debe ser autoincrementable
                pst.setInt(1, 0);
                pst.setString(2, userEntity.getUserName());
                pst.setString(3, userEntity.getPass());
                pst.setString(4, userEntity.getNombre());
                pst.setString(5, userEntity.getApellidos());
                pst.setInt(6, State);
                pst.setLong(7, userEntity.getTelefono());
                pst.setString(8, userEntity.getEmail());
                pst.setString(9, userEntity.getNoDocumento());
                pst.setInt(10, userEntity.getRol().getType(userEntity.getRol()));
                pst.setInt(11, userEntity.getDocumentType().getType(userEntity.getDocumentType()));
                if (pst.executeUpdate() == 1) {
                    AddMessage("Se ha añadido el Usuario correctamente.", MessageType.Confirmation);
                    return true;
                }

            }
        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);

        }
        return false;

    }

    public UserEntity getUserById(Long id) {
        UserEntity userEntity = new UserEntity();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from usuarios where idUsuarios =" + id);
            if (rs != null) {
                while (rs.next()) {

                    userEntity.setIdUsuario(Long.parseLong(getAttributeStringByRs("idUsuarios")));
                    userEntity.setUserName(getAttributeStringByRs("NombreUsuario"));
                    userEntity.setNombre(getAttributeStringByRs("Nombre"));
                    userEntity.setApellidos(getAttributeStringByRs("Apellidos"));
                    if (Integer.parseInt(getAttributeStringByRs("Activo")) == 1) {
                        userEntity.setActivo(true);
                    } else {
                        userEntity.setActivo(false);
                    }
                    userEntity.setPass(getAttributeStringByRs("Contraseña"));
                    userEntity.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    userEntity.setEmail(getAttributeStringByRs("CorreoElectronico"));
                    userEntity.setNoDocumento(getAttributeStringByRs("NumeroDocumento"));
                    userEntity.setRol(userEntity.getRol(Integer.parseInt(getAttributeStringByRs("Rol_idRol"))));
                    userEntity.setDocumentType(userEntity.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));
                }
            }

        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }
        return userEntity;
    }

        public UserEntity getUserByIdForChange(Long id) {
        UserEntity userEntity = new UserEntity();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from usuarios where idUsuarios =" + id);
            if (rs != null) {
                while (rs.next()) {

                    userEntity.setIdUsuario(Long.parseLong(getAttributeStringByRs("idUsuarios")));
                    userEntity.setUserName(getAttributeStringByRs("NombreUsuario"));
                    userEntity.setNombre(getAttributeStringByRs("Nombre"));
                    userEntity.setApellidos(getAttributeStringByRs("Apellidos"));
                    if (Integer.parseInt(getAttributeStringByRs("Activo")) == 1) {
                        userEntity.setActivo(true);
                    } else {
                        userEntity.setActivo(false);
                    }
                    userEntity.setPass(getAttributeStringByRs("Contraseña"));
                    userEntity.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    userEntity.setEmail(getAttributeStringByRs("CorreoElectronico"));
                    userEntity.setNoDocumento(getAttributeStringByRs("NumeroDocumento"));
                    userEntity.setRol(userEntity.getRol(Integer.parseInt(getAttributeStringByRs("Rol_idRol"))));
                    userEntity.setDocumentType(userEntity.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));
                }
            }

        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }
        return userEntity;
    }
        
    public UserEntity getUserByEmail(String email) {
        UserEntity userEntity = new UserEntity();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from usuarios where CorreoElectronico = '"+ email+"'");
            if (rs != null) {
                while (rs.next()) {

                    userEntity.setIdUsuario(Long.parseLong(getAttributeStringByRs("idUsuarios")));
                    userEntity.setUserName(getAttributeStringByRs("NombreUsuario"));
                    userEntity.setNombre(getAttributeStringByRs("Nombre"));
                    userEntity.setApellidos(getAttributeStringByRs("Apellidos"));
                    if (Integer.parseInt(getAttributeStringByRs("Activo")) == 1) {
                        userEntity.setActivo(true);
                    } else {
                        userEntity.setActivo(false);
                    }
                    userEntity.setPass(getAttributeStringByRs("Contraseña"));
                    userEntity.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    userEntity.setEmail(getAttributeStringByRs("CorreoElectronico"));
                    userEntity.setNoDocumento(getAttributeStringByRs("NumeroDocumento"));
                    userEntity.setRol(userEntity.getRol(Integer.parseInt(getAttributeStringByRs("Rol_idRol"))));
                    userEntity.setDocumentType(userEntity.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));
                }
            }

        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }
        return userEntity;
    }

    public boolean getUserByEmailAdd(String email) {
        UserEntity userEntity = new UserEntity();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from usuarios where CorreoElectronico = '"+email+"' ");
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

    public List<UserEntity> getUserList() {
        List<UserEntity> userEntityList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from usuarios  ORDER BY idUsuarios DESC");
            if (rs != null) {
                while (rs.next()) {
                    UserEntity userEntity = new UserEntity();
                    userEntity.setIdUsuario(Long.parseLong(getAttributeStringByRs("idUsuarios")));
                    userEntity.setUserName(getAttributeStringByRs("NombreUsuario"));
                    userEntity.setNombre(getAttributeStringByRs("Nombre"));
                    userEntity.setApellidos(getAttributeStringByRs("Apellidos"));
                    if (Integer.parseInt(getAttributeStringByRs("Activo")) == 1) {
                        userEntity.setActivo(true);
                    } else {
                        userEntity.setActivo(false);
                    }

                    userEntity.setTelefono(Long.parseLong(getAttributeStringByRs("Telefono")));
                    userEntity.setEmail(getAttributeStringByRs("CorreoElectronico"));
                    userEntity.setNoDocumento(getAttributeStringByRs("NumeroDocumento"));
                    userEntity.setRol(userEntity.getRol(Integer.parseInt(getAttributeStringByRs("Rol_idRol"))));
                    userEntity.setDocumentType(userEntity.getDocumentType(Integer.parseInt(getAttributeStringByRs("Tipodedocmuento_idTipodedocmuento"))));
                    userEntityList.add(userEntity);
                }
            }

        } catch (Exception ex) {
            AddMessage("Ha ocurrido un error: " + ex.getMessage(), MessageType.Error);
        }
        return userEntityList;
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
}
