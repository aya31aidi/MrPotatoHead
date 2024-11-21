package potato;

import java.util.Stack;

public class PotatoStateManager {
    private Stack<PotatoComponent> history = new Stack<>();
    private Stack<PotatoComponent> redoHistory = new Stack<>(); // For next state
    private PotatoComponent baseState;
    
    public PotatoStateManager(PotatoComponent baseState) {
        this.baseState = baseState;
        history.push(baseState); // Always push the base state at the beginning
    }

    // Save the current state
    public void saveState(PotatoComponent state) {
        history.push(state);
        redoHistory.clear(); // Clear redo history when a new action occurs
    }

    // Revert to the previous state
    public PotatoComponent previousState() {
        if (history.size() > 1) {  // Ensure the base state is not removed
            PotatoComponent currentState = history.pop(); // Pop the last state
            redoHistory.push(currentState); // Save it in the redo history for next
            return history.peek();  // Return the previous state, which is not the base state
        }
        return baseState; // If no previous state, return the base state
    }

    // Move forward to the next state
    public PotatoComponent nextState() {
        if (!redoHistory.isEmpty()) {
            PotatoComponent next = redoHistory.pop(); // Get the next state
            history.push(next); // Add the state back to history
            return next;
        }
        return null; // No next state
    }
}
