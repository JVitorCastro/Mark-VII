package va.mark7.modeladores;

import java.util.ArrayList;
import java.util.List;

public class AgentsDao {
    private List<AgentsModel> agents;

    public AgentsDao() {
        this.agents = new ArrayList<AgentsModel>();

        AgentsModel natasha = new AgentsModel();
        natasha.setId(1);
        natasha.setNome("Natasha");
        this.agents.add(natasha);

        AgentsModel clint = new AgentsModel();
        clint.setId(2);
        clint.setNome("Clint");
        this.agents.add(clint);
    }

    public List<AgentsModel> getAgents() {
        return agents;
    }

    public void addAgents(AgentsModel agent) {
        this.agents.add(agent);
    }
}
