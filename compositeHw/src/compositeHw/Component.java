package compositeHw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Component implements Iterable<Component>, Iterator<Component> {
	String name;
	int position = 0;
	List<Component> components = new ArrayList<>();

	public Component(String name) {
		this.name = name;
	}

	public Component add(Component branch) {
		components.add(branch);
		return branch;
	}

	public Component remove(Component branch) {
		components.remove(branch);
		return branch;
	}

	public String getName() {
		return name;
	}

	// public abstract String toString(); // зачем?

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(print());
		for (Component branch : components) {
			stringBuilder.append("\t");
			stringBuilder.append(branch.toString());
		}
		return stringBuilder.toString();
	}

	public String showReport() {
		return "report on " + name + " was made " + java.time.LocalDate.now().toString();
	}

	String print() {
		StringBuilder stringBuilder = new StringBuilder("\t" + name); // может и не нужен здесь StringBuilder?
		stringBuilder.append("\n");

		return stringBuilder.toString();
	}

	@Override
	public Iterator<Component> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return !(position >= components.size() || components.get(position) == null);
	}

	@Override
	public Component next() {
		return components.get(++position);
	}
}
