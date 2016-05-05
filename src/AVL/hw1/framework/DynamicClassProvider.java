package AVL.hw1.framework;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DynamicClassProvider {
	private static Map<Pair<String, String>, String> classMap = new HashMap<Pair<String, String>, String>(); // nick,
																												// creator,
																												// classpath
	private static Map<Pair<String, String>, WeakReference<IPrintable>> classCache = new HashMap<Pair<String, String>, WeakReference<IPrintable>>(); // chache

	public static void register(String nick, String creator, String path) {
		Pair<String, String> key = new Pair<String, String>(nick, creator);
		DynamicClassProvider.classMap.put(key, path);
		System.out.println("[ServiceProvider]"+ key + ": registered");
	}

	public static Object newInstance(String nick, String creator) {
		Pair<String, String> key = new Pair<String, String>(nick, creator);
		
		WeakReference<IPrintable> cachedObj = DynamicClassProvider.classCache.get(key);
		if (cachedObj != null) {	// cahce된게 있음
			IPrintable obj = cachedObj.get();
			System.out.println("[ServiceProvider]"+ key + ": found in cache");
			return obj;
		}

		String classPath = DynamicClassProvider.classMap.get(key);

		Class<?> cl;
		IPrintable obj = null;
		try {
			System.out.println(classPath);
			cl = Class.forName(classPath);
			obj = (IPrintable)cl.newInstance();
			WeakReference<IPrintable> wr = new WeakReference<IPrintable>(obj);
			DynamicClassProvider.classCache.put(key, wr);
			System.out.println("[ServiceProvider]"+ key + ": class loaded");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
}
