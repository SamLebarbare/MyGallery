package controllers;

import java.io.File;
import play.mvc.*;
import java.util.*;
import models.*;
import play.Play;
import play.data.validation.Required;


public class manage extends Controller {

    public static void index() {     
        List<Gallery> all = Gallery.findAll();
        
        render(all);
    }
        
    public static void create()
    {
        render();
    }
    
    public static void createGallery(String url,String title,String subtitle) {
        
        Gallery exist = Gallery.find("byUrl",url).first();
        if(exist!=null)
        {
            index();
        }
        else
        {
            Gallery newGallery = new Gallery(url,title,subtitle);
            newGallery.save();       
            index();
        }
        
    }
    
    public static void editGallery(Long id,String url,String title,String subtitle) {
        
        Gallery edit = Gallery.findById(id);
        if(edit==null)
        {
            edit(id);
        }
        else
        {
            edit.subtitle = subtitle;
            edit.title = title;
            edit.url = url;
            edit.save();       
            edit(id);
        }
        
    }
    
    public static void upload(Long id) {
        
        Gallery g = Gallery.findById(id);

        render(g);
    }
      
    public static void edit(Long id) {
        
        Gallery g = Gallery.findById(id);

        render(g);
    }
    
    public static void postFile(@Required Long id,@Required File img)
    {
  
        Gallery g = Gallery.findById(id);
        
        System.out.println("postFile");
        File newFile=Play.getFile("/public/images/gallery/" + img.getName());
        img.renameTo(newFile);
        System.out.println(newFile);
        img.delete();
        Photo photo = new Photo(newFile.getName());
        photo.gallery = g;
        photo.save();
        
        
        upload(id);
        
       
    }
     
    public static void deletePhoto(Long gId,Long id)
    {
        Photo image = Photo.findById(id);
        image.delete();
        
        upload(gId);
    }

}
    

