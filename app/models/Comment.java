package models;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

/**
 *
 * @author Samuel Loup <samuel.loup at gmail.com>
 */
@Entity
public class Comment extends Model{
    
    public String from;
    public String comment;
    public Date publishedAt;
    
    @ManyToOne
    public Photo onImage;
    
    
    public Comment(String from, String comment)
    {
        this.from = from;
        this.comment = comment;
        this.save();
    }
    
}
