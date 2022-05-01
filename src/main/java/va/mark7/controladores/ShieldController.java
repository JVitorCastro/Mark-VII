package va.mark7.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import va.mark7.modeladores.AgentsDao;
import va.mark7.modeladores.AgentsModel;

import java.util.Iterator;
import java.util.List;

@RestController
public class ShieldController {
    private AgentsDao agentsList;

    public ShieldController() {
        this.agentsList = new AgentsDao();
    }

    @GetMapping("/agents")
    public List<AgentsModel> getAgentsList() {
        return agentsList.getAgents();
    }

    @GetMapping("/agents/{id}")
    public AgentsModel getAgentById(@PathVariable int id){
        for (Iterator iterator = agentsList.getAgents().iterator(); iterator.hasNext();){
            AgentsModel agent = (AgentsModel) iterator.next();
            if(agent.getId() == id){
                return agent;
            }
        }
        return null;
    }

    @PostMapping("/agents")
    @ResponseStatus(HttpStatus.CREATED)
    public AgentsModel cadastrarAgent(@RequestBody AgentsModel agent){
        int id = this.agentsList.getAgents().size() + 1;
        agent.setId(id);
        agentsList.addAgents(agent);
        return agent;
    }

    @DeleteMapping("/agents/{id}")
    public AgentsModel remover(@PathVariable int id) {
        for (Iterator iterator = agentsList.getAgents().iterator(); iterator.hasNext();){
            AgentsModel agent = (AgentsModel) iterator.next();
            if(agent.getId() == id){
                iterator.remove();
                return agent;
            }
        }
        return null;
    }

}
