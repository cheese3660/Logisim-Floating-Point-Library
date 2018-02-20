package com.cheese.IEEE754;


import java.awt.Graphics;

import javax.swing.JComboBox;

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

public class FPConst extends InstanceFactory{
	private static class FloatGetter implements StringGetter {
		@Override
		public String get() {
			// TODO Auto-generated method stub
			return "Value";
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
	public static final Attribute<Float> ATTR_FLOAT = new FloatAttribute("attrFloatValue",new FloatGetter());
	FPConst() {
		super("FP Const");
		setAttributes(new Attribute[] { ATTR_FLOAT}, new Object[] {0.0f});
		setOffsetBounds(Bounds.create(-70, -15, 70, 30));
		setPorts(new Port[] {
			new Port(0, 0, Port.OUTPUT, 32),
		});
	}

	@Override
	public void paintInstance(InstancePainter painter) {
		painter.drawBounds();
		painter.drawPorts();
		Graphics g = painter.getGraphics();
		GraphicsUtil.drawCenteredText(g, Float.toString(painter.getAttributeValue(ATTR_FLOAT)), painter.getBounds().getX() + painter.getBounds().getWidth()/2, painter.getBounds().getY() + painter.getBounds().getHeight()/2);
	}

	@Override
	public void propagate(InstanceState state) {
		// TODO Auto-generated method stub
		state.setPort(0,FloatHelper.floatToFloatValue(state.getAttributeValue(ATTR_FLOAT)),0);
	}
}
