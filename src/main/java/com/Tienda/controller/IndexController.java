package com.Tienda.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Tienda.domain.Cliente;
import com.Tienda.dao.ClienteDao;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private ClienteDao ClienteDao;
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");

        /*Cliente cliente = new Cliente("Camila", "Luna Castro", "cluna20908@ufide.ac.cr", "85132722");
        Cliente cliente2 = new Cliente("Juan", "Lopez Rojas", "cluna20908@ufide.ac.cr", "85132722");
        Cliente cliente3 = new Cliente("Pedro", "Lopez Rojas", "cluna20908@ufide.ac.cr", "85132722");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/
        
        var clientes = ClienteDao.findAll();
        model.addAttribute("clientes", clientes);
        return "index";
    }

}
