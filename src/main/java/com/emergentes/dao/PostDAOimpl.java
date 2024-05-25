package com.emergentes.dao;

import com.emergentes.modelo.Post;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAOimpl extends ConexionDB implements PostDAO {

    @Override
    public void insert(Post post) throws Exception {
        String sql = "INSERT INTO posts(fecha,titulo, contenido) VALUES(?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, post.getFecha());
        ps.setString(2, post.getTitulo());
        ps.setString(3, post.getContenido());
        //ejecutar la consulta
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Post post) throws Exception {
        String sql = "UPDATE posts SET fecha=?, titulo=?, contenido=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, post.getFecha());
        ps.setString(2, post.getTitulo());
        ps.setString(3, post.getContenido());
        ps.setInt(4, post.getId());
        //ejecutar la consulta de actualizacion
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM posts where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        //ejecutar la consulta
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Post> getAll() throws Exception {
        ArrayList<Post> lista = null;
        String sql = "SELECT *FROM posts ORDER BY fecha DESC;";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        //obtener la consula
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Post>();
        //poner dentro la lista y recorido
        while (rs.next()) {
            Post pos = new Post();
            pos.setId(rs.getInt("id"));
            pos.setFecha(rs.getString("fecha"));
            pos.setTitulo(rs.getString("titulo"));
            pos.setContenido(rs.getString("contenido"));
            lista.add(pos);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Post getById(int id) throws Exception {

        Post pos = new Post();
        try {
            String sql = "SELECT * FROM posts where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            //recorrido
            while (rs.next()) {
                pos.setId(rs.getInt("id"));
                pos.setFecha(rs.getString("fecha"));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pos;
    }

}
