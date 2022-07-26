package com.Tienda.controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticuloController {

    
    @Autowired
    private ArticuloService ArticuloService;

     @Autowired
    private CategoriaService CategoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = ArticuloService.getArticulos(false);
        model.addAttribute("articulo", articulos);
        return "/articulo/listado";
    }
    
    @GetMapping("/articulo//nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = CategoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        ArticuloService.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = CategoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        articulo = ArticuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        ArticuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
}
