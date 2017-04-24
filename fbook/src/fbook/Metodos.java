/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author agarridogarcia
 */
public class Metodos {
    static Facebook facebook;
    public void password(){
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
    .setOAuthAppId("1813009045693822")
    .setOAuthAppSecret("8eff926fb8b966d5b2e47c62b42954dd")
    .setOAuthAccessToken("EAAZAw7BAkpX4BAB3aoDpxrvmmX83O1Qw1ZCmWdLFtbPHjBzNt2LDPEAZAOSgrI0ToSBZAZBTmxHjM1XQV7R4mteETTYkYjsyvaNVtcVG0jzvSVzNlJ5ZBMGkxpSl9WRuhZBgTVG69UJlcPzjmhQcZCniCeiWaviAYA3ORPKJcf0Bi1qZCZCoZAU4jBqz2oIlneZC4ATZChVTEeqo7ZAQZDZD")
    .setOAuthPermissions("email,publish_stream,...");
    FacebookFactory ff = new FacebookFactory(cb.build());
    facebook = ff.getInstance();
    }
    
    public void publicarPost() {
        try {
            facebook.postStatusMessage("Hola!!");
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void publicar () {
        PostUpdate post = null;
        try {
            post = new PostUpdate(new URL("http://facebook4j.org"))
                    .picture(new URL("http://www.prague.eu/file/edee/2014/09/cd-pano-579-kolebka-312-archiv_0187_panorama_neg41_31.jpg"))
                    .name("Facebook4J - A Java library for the Facebook Graph API")
                    .caption("facebook4j.org")
                    .description("Foto de Praga.");
        } catch (MalformedURLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void darLike(){
        String postId = null;
        try {
            facebook.likePost(postId);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscarPost(){
        try {
            ResponseList<Post> results = facebook.searchPosts("azul");
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void publicarComentario(){
        String photoId = null;
        try {
            facebook.commentPhoto(photoId, "Bonita foto!");
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
