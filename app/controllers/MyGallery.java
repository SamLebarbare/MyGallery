package controllers;



import play.mvc.*;


import models.*;
import play.Play;


public class MyGallery extends Controller {

    public static void index() 
    {
        
        render();
    }
    
    
    public static void display(String url)
    {
        Gallery g = Gallery.find("byUrl",url).first();
        if(g!=null)
        {
            render(g);
        }
        else
        {
            index();
        }
        
    }
    
    public static void download(Long id)
    {
        Photo image = Photo.findById(id);
       
        
        renderBinary(Play.getFile("/public/images/gallery/" + image.filename));
    }
    

}
    

