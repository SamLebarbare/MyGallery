package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import play.db.jpa.Model;

/**
 *
 * @author Samuel Loup <samuel.loup at gmail.com>
 */
@Entity
public class Photo extends Model{
    
   
    @ManyToOne
    public Gallery gallery;
    
    public String filename;
    
    
    @OneToMany
    public List<Comment> comments;
    
    public Photo(String filename)
    {
        this.filename = filename;
        
        this.comments = new ArrayList<Comment>();
        this.save();
    }
    
    
    public void addComment(Comment com)
    {
        this.comments.add(com);
        this.save();
    }
    
}
