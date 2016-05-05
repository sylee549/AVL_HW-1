package AVL.hw1.test;

import AVL.hw1.framework.DynamicClassProvider;
import AVL.hw1.framework.IPrintable;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicClassProvider.register("myclass", "SungYupLee", "AVL.hw1.myClass.MyClass1");
		Object my1 = DynamicClassProvider.newInstance("myclass", "SungYupLee");
		((IPrintable)my1).printName();
		Object my2 = DynamicClassProvider.newInstance("myclass", "SungYupLee");
		((IPrintable)my2).printName();
	}

}
