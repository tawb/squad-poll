package composite;

import java.util.ArrayList;
import java.util.List;

public class PollGroup implements PollComponent {
    private final String groupName;
    private final List<PollComponent> children = new ArrayList<>();

    public PollGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(PollComponent child) {
        children.add(child);
    }
 ////the loop calls child.describe() on each one, and if a child is actually
//another PollGroup instead of a PollLeaf, this exact method runs again on it
//so nested groups just work without me writing extra code for that case
    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder(groupName + ": [");
        for (PollComponent child : children) {
            sb.append(child.describe()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
 ////same recursive thing here, if a child is a PollGroup, isFullyClosed()
//runs again on it and checks its own children
    @Override
    public boolean isFullyClosed() {
        return children.stream().allMatch(PollComponent::isFullyClosed);
    }
}