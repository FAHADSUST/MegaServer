/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver.models;

/**
 *
 * @author Fahad-PC
 */
public class Image {
    private int image_id;
    private String url;
    private int person_id;

    public Image(int image_id, String url, int person_id) {
        this.image_id = image_id;
        this.url = url;
        this.person_id = person_id;
    }

    
    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
    
    
}
