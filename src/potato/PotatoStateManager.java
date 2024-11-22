package potato;

import java.util.Stack;

public class PotatoStateManager {
    private Stack<PotatoComponent> history = new Stack<>();  // Stack to track the history of states
    private Stack<PotatoComponent> redoHistory = new Stack<>();  // Stack for redo functionality
    private PotatoComponent baseState;  // The base state of the potato

    // Constructor initializing with the base state and pushing it to history
    public PotatoStateManager(PotatoComponent baseState) {
        this.baseState = baseState;
        history.push(baseState);  // Push the base state at the beginning of the history
    }

    // Method to save the current state
    public void saveState(PotatoComponent state) {
        history.push(state);  // Push the current state to the history stack
        redoHistory.clear();  // Clear redo history when a new state is created
    }

    // Method to revert to the previous state
    public PotatoComponent previousState() {
        if (history.size() > 1) {  // Ensure that we are not removing the base state
            PotatoComponent currentState = history.pop();  // Pop the current state
            redoHistory.push(currentState);  // Save it in the redo stack
            return history.peek();  // Return the previous state
        }
        return baseState;  // Return the base state if no previous state exists
    }

    // Method to move forward to the next state
    public PotatoComponent nextState() {
        if (!redoHistory.isEmpty()) {  // Check if there are states in the redo history
            PotatoComponent next = redoHistory.pop();  // Pop the next state
            history.push(next);  // Push it back to the history stack
            return next;  // Return the next state
        }
        return null;  // Return null if no next state exists
    }
}
