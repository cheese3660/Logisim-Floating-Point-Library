package com.cheese.IEEE754;

import com.cburch.logisim.data.BitWidth;
import com.cburch.logisim.data.Value;

public class FloatHelper {
	//2's complement
	private static int valueToSignedInt(Value x) {
		if (x.get(32).toIntValue() == 1) { //Signed
			Value x2 = x.not();
			int x3 = x2.toIntValue() + 1;
			return -x3;
		}
		return x.toIntValue();
	}
	//2's complement
	private static Value signedIntToValue(int x) {
		Value n = Value.createKnown(BitWidth.create(32),Math.abs(x));
		if (x < 0) {
			n = n.not();
			n = Value.createKnown(BitWidth.create(32),n.toIntValue()+1);
		}
		return n;
	}
	static float valueToFloat(Value x) {
		return (float)valueToSignedInt(x);
	}
	static float floatValueToFloat(Value x) {
		return Float.intBitsToFloat(x.toIntValue());
	}
	static Value floatToValue(float x) {
		return signedIntToValue((int)x);
	}
	static Value floatToFloatValue(float x) { 
		return Value.createKnown(BitWidth.create(32), Float.floatToIntBits(x));
	}
	static Value floatValueToValue(Value x) {
		return floatToValue(floatValueToFloat(x));
	}
	static Value valueToFloatValue(Value x) {
		return floatToFloatValue(valueToFloat(x));
	}
}
