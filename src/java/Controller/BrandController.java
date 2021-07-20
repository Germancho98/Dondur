/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Brand;
import Util.MessageType;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class BrandController extends Util.Util {
    
    ResultSet rs;
    Statement st;
    
    public ResultSet getRs() {
        return rs;
    }
    
    public Brand getBrandById(Long id) {
        Brand brand = new Brand();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from marca where idMarca =" + id);
            if (rs != null) {
                while (rs.next()) {
                    brand.setIdMarca(Long.parseLong(getAttributeStringByRs("idMarca")));
                    brand.setNombreMarcas(getAttributeStringByRs("NombreMarcas"));
                }
            }
            
        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return brand;
    }
    
    public List<Brand> getBrandList() {
        List<Brand> brandList = new ArrayList<>();
        try {
            st = this.getConnection().createStatement();
            rs = st.executeQuery("select * from marca");
            if (rs != null) {
                while (rs.next()) {
                    Brand brand = new Brand();
                    brand.setIdMarca(Long.parseLong(getAttributeStringByRs("idMarca")));
                    brand.setNombreMarcas(getAttributeStringByRs("NombreMarcas"));
                    brandList.add(brand);
                }
            }
            
        } catch (Exception e) {
            AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
        }
        return brandList;
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
