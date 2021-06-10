package gob.mx.issste.siscal.old.api.server.utils;

import java.util.Collection;

public class Util {
	public static boolean isEmpty(Collection<?> obj) {
        return obj == null || obj.isEmpty();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || obj.toString().trim().isEmpty();
    }
}
