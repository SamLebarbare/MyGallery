package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import play.db.jpa.Model;

/**
 *
 * @author Samuel Loup <samuel.loup at gmail.com>
 */
@Entity
public class Gallery extends Model
{

    public String url;
    public String title;
    public String subtitle;
    
    @OneToMany(mappedBy="gallery")
    public List<Photo> photos;
    
    
    public Gallery(String url,String title,String subtitle)
    {
        this.url = url;
        this.subtitle = subtitle;
        this.title = title;
        this.photos = new ArrayList<Photo>();
    }
    
    
    
    
}
