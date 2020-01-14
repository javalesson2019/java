package compositeHw; // FIXME: В именах пакетов не следует использовать прописные (большие) буквы

public class Branch extends Component {

	public Branch(String name) {
		// this.name = name; // т.к. поле name опеределено в родителе, то лучше передать
		// в конструктор
		super(name);
	}
}
