import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {
    private List<Item> createItems(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
    @Test
    void BranchTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 200));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("items", "157b", 100, 0)),150));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        assertTrue(SILab2.checkCart( createItems(new Item(null, "1789", 170, 0)),230));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart( createItems(new Item("fruit", null, 20, 45)),65));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertFalse(SILab2.checkCart( createItems(new Item("coctail", "036", 460, 6)),330));
    }

    @Test
    void MultipleCondTest(){
        RuntimeException ex;
        Item TTT = new Item("example1", "0345", 420, 5);
        Item TTF = new Item("example2", "280", 380, 3);
        Item TFX = new Item("example3", "47", 510, -2);
        Item FXX = new Item("example4", "123", 260, 0);

        assertFalse(SILab2.checkCart( createItems(TTT),160));
        assertFalse(SILab2.checkCart( createItems(TTF),170));
        assertFalse(SILab2.checkCart( createItems(TFX),180));
        assertFalse(SILab2.checkCart( createItems(FXX),190));
    }
}