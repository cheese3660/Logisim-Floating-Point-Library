package com.cheese.IEEE754;

import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.Attributes;
import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceFactory;
import com.cburch.logisim.instance.InstancePainter;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.instance.Port;
import com.cburch.logisim.instance.StdAttr;
import com.cburch.logisim.util.GraphicsUtil;
import com.cburch.logisim.util.StringGetter;

public class Comparator extends InstanceFactory{
	private static class FloatGetter implements StringGetter {
		@Override
		public String get() {
			// TODO Auto-generated method stub
			return "Leeway";
		}
	}
	private static class FloatAttribute extends Attribute<Float> {
		private FloatAttribute(String name, StringGetter disp) {
			super(name, disp);
		}

		@Override
		public Float parse(String value) {
			return Float.valueOf(value);
		}
	}
	public static final Attribute<Float> ATTR_LEEWAY = new FloatAttribute("attrLeewayValue",new FloatGetter());
	public Comparator() {
		super("Comparator");
		setAttributes(new Attribute[] { ATTR_LEEWAY}, new Object[] {0.0f});
		setOffsetBounds(Bounds.create(-30, -20, 30, 40));
		setPorts(new Port[] {
			new Port(-30,-10,Port.INPUT,32), //A
			new Port(-30,10,Port.INPUT,32), //B
			new Port(0,-10,Port.OUTPUT,1), //<
			new Port(0,0,Port.OUTPUT,1), //==
			new Port(0,10,Port.OUTPUT,1), //>
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
		float a = FloatHelper.floatValueToFloat(state.getPort(0));
		float b = FloatHelper.floatValueToFloat(state.getPort(1));
		float diff = Math.abs(b-a);
		if (diff <= state.getAttributeValue(ATTR_LEEWAY)) {
			state.setPort(2, Value.FALSE, 1);
			state.setPort(3, Value.TRUE, 1);
			state.setPort(4, Value.FALSE, 1);
		} else if (a < b) {
			state.setPort(2, Value.TRUE, 1);
			state.setPort(3, Value.FALSE, 1);
			state.setPort(4, Value.FALSE, 1);
		} else {
			state.setPort(2, Value.FALSE, 1);
			state.setPort(3, Value.FALSE, 1);
			state.setPort(4, Value.TRUE, 1);
		}
	}

}
