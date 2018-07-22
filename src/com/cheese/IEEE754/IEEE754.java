package com.cheese.IEEE754;

import java.util.Arrays;
import java.util.List;

import com.cburch.logisim.tools.AddTool;
import com.cburch.logisim.tools.Library;

/** The library of components that the user can access. */
public class IEEE754 extends Library {
    /** The list of all tools contained in this library. Technically,
     * libraries contain tools, which is a slightly more general concept
     * than components; practically speaking, though, you'll most often want
     * to create AddTools for new components that can be added into the circuit.
     */
    private List<AddTool> tools;
    
    /** Constructs an instance of this library. This constructor is how
     * Logisim accesses first when it opens the JAR file: It looks for
     * a no-arguments constructor method of the user-designated class.
     */
    public IEEE754() {
        tools = Arrays.asList(new AddTool[] {
        		new AddTool(new Adder()),
        		new AddTool(new BinToFP()),
        		new AddTool(new FPToBin()),
        		new AddTool(new Subtractor()),
        		new AddTool(new Multiplier()),
        		new AddTool(new Divider()),
        		new AddTool(new Sin()),
        		new AddTool(new Cos()),
        		new AddTool(new Tan()),
        		new AddTool(new ISin()),
        		new AddTool(new ICos()),
        		new AddTool(new ITan()),
        		new AddTool(new Sqrt()),
        		new AddTool(new Mod()),
        		new AddTool(new FPProbe()),
        		new AddTool(new FPConst()),
        		new AddTool(new Comparator()),
        		new AddTool(new Root()),
        		new AddTool(new Log()),
        		new AddTool(new Exponentiate()),
        		new AddTool(new Pow()),
        		new AddTool(new LN()),
        });
    }
    
    /** Returns the name of the library that the user will see. */ 
    public String getDisplayName() {
        return "IEEE754";
    }
    
    /** Returns a list of all the tools available in this library. */
    public List<AddTool> getTools() {
        return tools;
    }
}