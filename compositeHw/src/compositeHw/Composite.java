package compositeHw;

public class Composite {
	public static void main(String[] args) {
		Corporation ms = new Corporation("MS");
		
		Branch hh = new Branch("HH");
		ms.add(hh);
		
		Branch market = new Branch("Market");
		ms.add(market);
		
		Branch dev = new Branch("Development");
		ms.add(dev);
		
		Department usa = new Department("USA");
		Department uk = new Department("UK");
		Department eu = new Department("EU");
		
		market.add(usa);
		market.add(uk);
		market.add(eu);
		
		Department game = new Department("Game");
		Department office = new Department("Office");
		Department os = new Department("OS");
		
		dev.add(game);
		dev.add(office);
		dev.add(os);
		
		//структура корпорации
		System.out.println(ms.toString());
		
		//отчет 
		System.out.println(os.showReport());
		
 }
}

