package compositeHw;

public class Corporation extends Component{

	public Corporation(String name) {
		this.name = name;
	}

	@Override
	public Component add(Component c) {
		components.add(c);
		return c;
	}

	@Override
	public Component remove(Component c) {
		components.add(c);
		return c;
	}

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

	@Override
	public String showReport() {
		String report = "report on " + name +" was made " + java.time.LocalDate.now().toString();
		return report;
	}
	
}
