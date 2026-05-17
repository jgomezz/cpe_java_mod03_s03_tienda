package pe.edu.tecsup.tienda.webs;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.tecsup.tienda.domain.Producto;
import pe.edu.tecsup.tienda.services.ProductoService;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping()
    public String index(Model model) {

        List<Producto> productos = this.productoService.findAll();  // TO DO

        model.addAttribute("productos", productos);

        return "/productos/index";
    }

}
