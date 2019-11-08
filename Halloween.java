import java.util.Scanner;
import java.util.Random;

public class Halloween {

	Scanner scan = new Scanner(System.in);

	private int houses;
	private int snickers;
	private int reeses;
	private int lollypops;
	private int otherCandy;
	private boolean notTired = true;

	public void Halloween() {
		houses = 0;
		snickers = 0;
		reeses = 0;
		lollypops = 0;
		otherCandy = 0;
		notTired = true;
	}

	public void Halloween(int housesIn) {
		houses = housesIn;
		snickers = 1;
		reeses = 3;
		lollypops = 0;
		otherCandy = 0;
	}

	public void Halloween(int housesIn, int snickersIn, int reesesIn, int lollypopsIn, int otherCandyIn) {
		houses = housesIn;
		snickers = snickersIn;
		reeses = reesesIn;
		lollypops = lollypopsIn;
		otherCandy = otherCandyIn;

	}

	public boolean isLightOn() {
		houses++;
		return Math.random() < 0.5;
	}

	public String response(int x) {
    String y = new String();

		if (x == 0) {
      y = "Cool costume!";
		} else if (x == 1) {
      y = "Aren’t you cute!";
		} else if (x == 2) {
      y = "Aren’t you a little old for this?";
		}
    return y;
	}

	public void tradeCandy() {
		System.out.println("I would like to trade candy");
		System.out.println("I'll trade:");
		String givingType = scan.next();
		System.out.println("For:");
		String gettingType = scan.next();
		System.out.println("Will you trade with me?");
		System.out.println("Yes!");

		if("snickers".equals(givingType.toLowerCase())) {
			snickers--;
		} else if("reeses".equals(givingType.toLowerCase())) {
			reeses--;
		} else if("lollypops".equals(givingType.toLowerCase())) {
			lollypops--;
		} else {
			otherCandy--;
		}

		if("snickers".equals(gettingType.toLowerCase())) {
			snickers++;
		} else if("reeses".equals(gettingType.toLowerCase())) {
			reeses++;
		} else if("lollypops".equals(gettingType.toLowerCase())) {
			lollypops++;
		} else {
			otherCandy++;
		}

    System.out.println("You traded, " + givingType + "for " + gettingType);
	}

	public void addCandy(int candyType, int amount) {
		if (candyType == 1) {
			snickers += amount;
		} else if (candyType == 2) {
			reeses += amount;
		} else if (candyType == 3) {
			lollypops += amount;
		} else {
			otherCandy += amount;
		}
	}

	public String totalCandy() {
		int total = snickers + reeses + lollypops + otherCandy;
		String x = "";
    x+="These are your candy totals:\n\n";
		x+="Snickers: " + snickers + "\n";
		x+="Reese's: " + reeses + "\n";
		x+="Lollypops: " + lollypops + "\n";
		x+="Other Candies: " + otherCandy + "\n";
		x+="Total Candies: " + total + "\n";

    return x;
	}

	public void trickOrTreat() {
		int currentType;
		int currentCount;
    String currentWillTrade;
    String currentIsTired;

		while(notTired) {
			if(isLightOn()) {
				System.out.println("The light of the house is on. You ring the doorbell adjacent to the front door");
			} else {
				System.out.println("The light is off in the house. You ring the doorbell next to the front door");
			}
			System.out.println("Trick Or Treat!");
			response((int)Math.floor(Math.random() * 3));
			currentType = (int)Math.floor(Math.random() * 3);
			currentCount = (int)Math.floor(Math.random() * 10);

			addCandy(currentType, currentCount);
			System.out.println("Thank you, Happy Halloween!");
			if (currentType == 1) {
				System.out.println("You got " + currentCount + " Snickers");
			} else if (currentType == 2) {
				System.out.println("You got " + currentCount + " Reese's");
			} else if (currentType == 3) {
				System.out.println("You got " + currentCount + " Lollypops");
			} else {
				System.out.println("You got " + currentCount + " Other Candy");
			}

      System.out.println("Are you tired yet?");
      currentIsTired = scan.next();

      if (notTired) {
        System.out.println("Being tired, you walk back to your house to count your candy.");
        break;
      } else {
        System.out.println("You continue Trick or Treating.");
      }      

      System.out.println("Would you like to trade?");
      currentWillTrade = scan.next();

      if ("yes".equals(currentWillTrade.toLowerCase())) {
        System.out.println("You ask your friends if they would like to trade.");
      } else {
        System.out.println("You go on with your friends to the next house");
      }

		}
	}

}