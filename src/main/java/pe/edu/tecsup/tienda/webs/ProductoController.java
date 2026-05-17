package pe.edu.tecsup.tienda.webs;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping()
    public String index(Model model) {

        // TO DO

        return "/productos/index";
    }

}
