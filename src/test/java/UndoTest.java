import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UndoTest {
    public Undo undoInstance;

    @BeforeEach
    public void init (){
        undoInstance = Undo.getInstance();
    }
    @AfterEach
    public void cleanit(){
        undoInstance.clearHistory();
    }

    @Test
    public void shouldTrhowException(){
        assertThrows(NoComands.class, () -> {
            undoInstance.unDo();
        });
        assertThrows(NoComands.class, () -> {
            undoInstance.getCommands();
        });
    }

    @Test
    public void shouldAddAndGetCommands(){
        undoInstance.addCommand("Comandito");
        assertEquals("Comandito", undoInstance.getCommands());

        undoInstance.addCommand("Comandito 2");
        assertEquals("Comandito\nComandito 2", undoInstance.getCommands());
    }

    @Test
    public void shouldGiveFeedBack(){
        assertEquals("Comandito added.", undoInstance.addCommand("Comandito"));
        assertEquals("previous command: Comandito undo. No more commands to undo.",
                undoInstance.unDo());
        undoInstance.addCommand("Comandito");
        undoInstance.addCommand("Super Comandito");
        assertEquals("previous command: Super Comandito undo. Now on command: Comandito.",
                undoInstance.unDo());
    }

}
