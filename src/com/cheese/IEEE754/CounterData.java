package com.cheese.IEEE754;

import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceData;
import com.cburch.logisim.instance.InstanceState;

/** Represents the state of a counter. */
class CounterData implements InstanceData, Cloneable {
    /** Retrieves the state associated with this counter in the circuit state,
     * generating the state if necessary.
     */
    public static CounterData get(InstanceState state) {
        CounterData ret = (CounterData) state.getData();
        if(ret == null) {
            // If it doesn't yet exist, then we'll set it up with our default
            // values and put it into the circuit state so it can be retrieved
            // in future propagations.
            ret = new CounterData(null, Value.createKnown(BitWidth.create(32), 0));
            state.setData(ret);
        }
        return ret;
    }

    /** The last clock input value observed. */
    
    /** The current value emitted by the counter. */
    private Value value;

    /** Constructs a state with the given values. */
    public CounterData(Value lastClock, Value value) {
        this.value = value;
    }

    /** Returns a copy of this object. */
    public Object clone() {
        // We can just use what super.clone() returns: The only instance variables are
        // Value objects, which are immutable, so we don't care that both the copy
        // and the copied refer to the same Value objects. If we had mutable instance
        // variables, then of course we would need to clone them.
        try { return super.clone(); }
        catch(CloneNotSupportedException e) { return null; }
    }
    
    
    /** Returns the current value emitted by the counter. */
    public Value getValue() {
        return value;
    }
    
    /** Updates the current value emitted by the counter. */
    public void setValue(Value value) {
        this.value = value;
    }
}