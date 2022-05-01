package va.mark7.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import va.mark7.modeladores.AgentsDao;
import va.mark7.modeladores.AgentsModel;

import java.util.List;

@RestController
public class ShieldController {
    private AgentsDao agentsList = new AgentsDao();

    @GetMapping("/agents")
    public List<AgentsModel> getAgentsList() {
        return agentsList.getAgents();
    }
}
