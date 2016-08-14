/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver;

import com.google.gson.Gson;
import com.sun.javafx.scene.layout.region.Margins.Converter;
import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author Fahad-PC
 */
public class GsonMaker 
{

    Gson gson;
    Convertor converter;
    public GsonMaker() 
    {
        gson = new Gson();
        converter = new Convertor();
    }
    
    String GetJsonData(ResultSet rs) throws Exception
    {
        JSONArray jSONArray  = converter.convertResultSetIntoJSON(rs);//convertToJSON(rs);
        System.out.println("jsonArra size : " +jSONArray.length());
        return jSONArray.toString();
    }
    
    public JSONArray convertToJSON(ResultSet resultSet) throws Exception 
    {
        JSONArray jsonArray = new JSONArray();

        while (resultSet.next()) 
        {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            
            for (int i = 0; i < total_rows; i++) 
            {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return jsonArray;
    }
    
    
}
