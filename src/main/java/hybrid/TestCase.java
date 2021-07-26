package hybrid;

import java.util.ArrayList;
import java.util.List;

import keyword.Action;

public class TestCase {

	private List<Action> actions;

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void add(Action action) {
		if(actions==null) {
			actions= new ArrayList<Action>();
		}
		actions.add(action);
	}

	@Override
	public String toString() {
		return "TestCase ["+ actions.get(0).getDescription() + "]";
	}
}
