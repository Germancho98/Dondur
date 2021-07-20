/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.State;
import Util.MessageType;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class StateController extends Util.Util {

    ResultSet rs;
    Statement st;

    public ResultSet getRs() {
        return rs;
    }

    public State getStateById(Long id) {
        State state = new State();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from estado where idEstado =" + id);
            if (rs != null) {
                while (rs.next()) {
                    state.setIdEstado(Long.parseLong(getAttributeStringByRs("idEstado")));
                    state.setNombreEstado(getAttributeStringByRs("NombreEstado"));
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return state;
    }

    public List<State> getStateList() {
        List<State> stateList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from estado");
            if (rs != null) {
                while (rs.next()) {
                    State state = new State();
                    state.setIdEstado(Long.parseLong(getAttributeStringByRs("idEstado")));
                    state.setNombreEstado(getAttributeStringByRs("NombreEstado"));
                    stateList.add(state);
                }
            }

        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return stateList;
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
