package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ClienteService ClienteService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");

        /*Cliente cliente = new Cliente("Camila", "Luna Castro", "cluna20908@ufide.ac.cr", "85132722");
        Cliente cliente2 = new Cliente("Juan", "Lopez Rojas", "cluna20908@ufide.ac.cr", "85132722");
        Cliente cliente3 = new Cliente("Pedro", "Lopez Rojas", "cluna20908@ufide.ac.cr", "85132722");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);*/
        var clientes = ClienteService.getCliente();
        model.addAttribute("clientes", clientes);

        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        ClienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = ClienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        ClienteService.delete(cliente);
        return "redirect:/";
    }
}
