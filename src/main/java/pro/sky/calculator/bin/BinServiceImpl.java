package pro.sky.calculator.bin;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@SessionScope
public class BinServiceImpl implements BinService {

    private final Map<Integer, Integer> bin = new HashMap<>();

    @Override
    public String addInBin(Integer prodId) {
        bin.put(prodId, bin.getOrDefault(prodId, 0) + 1);
        return String.format("Successful addition: %s", prodId);
    }

    @Override
    public List<Integer> getBin() {
        return bin.keySet().stream().toList();
    }
}