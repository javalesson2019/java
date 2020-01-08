package compositeHw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Component implements Iterable<Component>, Iterator<Component> {
	String name;
	int position = 0; 
	List<Component> components = new ArrayList<>();

	public abstract Component add(Component c);
	public abstract Component remove(Component c);

	public String getName() {
		return name;
	}

	public abstract String toString();
	public abstract String showReport();
	
	String print() {
		StringBuilder stringBuilder = new StringBuilder("\t" + name);
		stringBuilder.append("\n");

		return stringBuilder.toString();
	}

	@Override
	public Iterator<Component> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		if (position >= components.size() || 
				components.get(position) == null) 
	            return false; 
	        else
	            return true; 
	}

	@Override
	public Component next() {
		 Component cmpntnt =  components.get(position); 
	     position += 1; 
	     return cmpntnt; 
	}
}
