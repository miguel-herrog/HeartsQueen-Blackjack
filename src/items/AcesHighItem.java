package items;
import entities.Player;
import mechanics.Card;
import mechanics.Suit;

public class AcesHighItem extends Item {

    public AcesHighItem() {
        super("Aces High", "Cheater's delight! Magically slips an Ace into your hand.", 50, false);
    }

    public boolean applyEffect(Player player) {
        System.out.println("\n🃏 YOU SLIP AN ACE FROM YOUR SLEEVE! 🃏");
        System.out.println("The dealer didn't notice a thing... A magical Ace appears in your hand!");

        Card cheatedAce = new Card("Ace", 11, Suit.SPADES);
        player.addCardToHand(cheatedAce);

        return true;
    }
}