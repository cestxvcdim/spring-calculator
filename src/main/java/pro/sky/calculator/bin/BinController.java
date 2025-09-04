package pro.sky.calculator.bin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/store/order")
public class BinController {
    private final BinServiceImpl binService;

    public BinController(BinServiceImpl binService) {
        this.binService = binService;
    }

    @GetMapping(path = "/add")
    public String addInBin(@RequestParam("prodId") Integer prodId) {
        return binService.addInBin(prodId);
    }

    @GetMapping(path = "/get")
    public List<Integer> getBin() {
        return binService.getBin();
    }
}
