package compositeHw;

public class Branch extends Component{
	
	public Branch(String name) {
		this.name = name;
	}

	@Override
	public Component add(Component branch) {
		components.add(branch);
		return branch;
	}

	@Override
	public Component remove(Component branch) {
		components.remove(branch);
		return branch;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(print());
		for (Component branch : components) {
			stringBuilder.append("\t");
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
