package pe.edu.tecsup.tienda.webs;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.tecsup.tienda.domain.Categoria;
import pe.edu.tecsup.tienda.domain.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    private final CategoriaService categoriaService;

    @GetMapping()
    public String index(Model model) {

        List<Producto> productos = this.productoService.findAll();  // TO DO

        model.addAttribute("productos", productos);

        return "/productos/index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("categorias", this.categoriaService.findAll());

        Producto producto = Producto.builder()
                .categoria(Categoria.builder()
                        .build())
                .build();

        log.info(producto.toString());

        model.addAttribute("producto",producto);

        return "/productos/create";

    }

    @PostMapping("/store")
    public String store(@ModelAttribute("producto") Producto producto, Errors errors,
                        @RequestParam("file") MultipartFile file,
                        RedirectAttributes redirectAttrs) throws Exception{

        log.info(producto.toString());

        this.productoService.save(producto);

        return "redirect:/productos";

    }

}
