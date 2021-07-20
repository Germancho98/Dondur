/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Model;
import Util.MessageType;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class ModelController extends Util.Util {

    ResultSet rs;
    Statement st;

    public ResultSet getRs() {
        return rs;
    }

    public Model getModelById(Long id) {
        Model model = new Model();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from modelo where idModelo =" + id);
            if (rs != null) {
                while (rs.next()) {
                    model.setIdModelo(Long.parseLong(getAttributeStringByRs("idModelo")));
                    model.setNombreModelos(getAttributeStringByRs("NombreModelos"));
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return model;
    }

    public List<Model> getModelList() {
        List<Model> modelList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from modelo");
            if (rs != null) {
                while (rs.next()) {
                    Model model = new Model();
                    model.setIdModelo(Long.parseLong(getAttributeStringByRs("idModelo")));
                    model.setNombreModelos(getAttributeStringByRs("NombreModelos"));
                    modelList.add(model);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return modelList;

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
