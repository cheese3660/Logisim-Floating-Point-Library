package com.cheese.IEEE754;

import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Direction;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.util.StringGetter;

public class BinToFP extends InstanceFactory {
	BinToFP() {
		super("Int To FP");
        setAttributes(new Attribute[] {  },
                new Object[] {  });
        
        setOffsetBounds(Bounds.create(-20,-20,20,40));
        
        setPorts(new Port[] {
        		new Port(-20,0,Port.INPUT,32), //BinNum in
        		new Port(0,0,Port.OUTPUT,32), //FPNum out
            });
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		// TODO Auto-generated method stub
		painter.drawBounds();
		painter.drawPorts();
	}

	@Override
	public void propagate(InstanceState state) {
		// TODO Auto-generated method stub
		state.setPort(1, FloatHelper.valueToFloatValue(state.getPort(0)), 1);
	}
	
}
