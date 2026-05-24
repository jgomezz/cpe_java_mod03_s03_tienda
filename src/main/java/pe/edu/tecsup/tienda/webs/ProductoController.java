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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws Exception {


        Producto producto = this.productoService.findById(id);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", this.categoriaService.findAll());

        return "productos/edit";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("producto") Producto producto,
                         Errors errors,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttrs) throws Exception{

            this.productoService.save(producto);

        return "redirect:/productos";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes
            redirectAttrs) throws Exception {

        log.info("edit delete(id: " + id + ")");

        this.productoService.deleteById(id);

        return "redirect:/productos";
    }

}
