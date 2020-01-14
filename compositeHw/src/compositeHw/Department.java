package compositeHw;

public class Department extends Component {

	public Department(String name) {
		// this.name = name;
		super(name);
	}

	@Override
	public String toString() {
		return print();
	}

	@Override
	public Component add(Component menuComponent) {
		throw new UnsupportedOperationException("cannot add");
	}

	@Override
	public Component remove(Component menuComponent) {
		throw new UnsupportedOperationException("cannot remove");
	}
}
