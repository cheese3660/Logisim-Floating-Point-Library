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
import com.cburch.logisim.util.GraphicsUtil;
import com.cburch.logisim.util.StringGetter;

public class FPProbe extends InstanceFactory {
	FPProbe() {
		super("FP Probe");
        setAttributes(new Attribute[] {  },
                new Object[] {  });
        
        setOffsetBounds(Bounds.create(-80,-10,80,20));
        
        setPorts(new Port[] {
        		new Port(-80,0,Port.INPUT,32), //FPNum In
            });
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		CounterData s = CounterData.get(painter);
		float v = FloatHelper.floatValueToFloat(s.getValue());
		// TODO Auto-generated method stub
		painter.drawBounds();
		painter.drawPorts();
		Bounds bds = painter.getBounds();
		GraphicsUtil.drawCenteredText(painter.getGraphics(), Float.toString(v), bds.getX() + bds.getWidth()/2, bds.getY() + bds.getHeight()/2);
	}

	@Override
	public void propagate(InstanceState state) {
		CounterData cur = CounterData.get(state);
		cur.setValue(state.getPort(0));
	}
	
}
