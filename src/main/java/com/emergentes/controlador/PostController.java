package com.emergentes.controlador;

import com.emergentes.dao.PostDAO;
import com.emergentes.dao.PostDAOimpl;
import com.emergentes.modelo.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PostController", urlPatterns = {"/PostController"})
public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        PostDAO dao = new PostDAOimpl();
        Post pos = new Post();
        int id;
        String action = (request.getParameter("action") != null)?request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("post", pos);
                request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
            
                    pos = dao.getById(id);
                    System.out.println("pos");
                
            
                //poner como atributo 
                request.setAttribute("post", pos);
                request.getRequestDispatcher("frmpost.jsp").forward(request, response);
                
                
                break;

            case "delete":
                id= Integer.parseInt(request.getParameter("id"));
            
                    dao.delete(id);
                response.sendRedirect(request.getContextPath()+"/PostController");
                
                break;

            case "view":
            List<Post> lista = dao.getAll();
            request.setAttribute("posts", lista);
            request.getRequestDispatcher("posts.jsp").forward(request, response);
            default:
                break;
        }
    }catch(Exception ex){
            System.out.println("ERRORRRRRRR"+ex.getMessage());
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo= request.getParameter("titulo");
        String contenido= request.getParameter("contenido");
        
        Post pos = new Post();
        pos.setId(id);
        pos.setFecha(fecha);
        pos.setTitulo(titulo);
        pos.setContenido(contenido);
        if(id == 0){
            try {
                PostDAO dao = new PostDAOimpl();
                //nuevo registro
                dao.insert(pos);
                response.sendRedirect(request.getContextPath()+"/PostController");
            } catch (Exception ex) {
                System.out.println("ERROR AL INSERTAR"+ex.getMessage());
            }
        }else{
            try {
                PostDAO dao = new PostDAOimpl();
                //edicion de registro
                dao.update(pos);
                response.sendRedirect(request.getContextPath()+"/PostController");
            } catch (Exception ex) {
                System.out.println("ERROR AL EDITAR"+ex.getMessage());
            }
        }
    }
}
