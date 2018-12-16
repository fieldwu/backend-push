package com.basic.backend.push.support.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.google.common.base.Throwables;

/**
 * JavaBean工具类
 * 
 * @author Field
 */
public class BeanUtils {

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	public static void copyPropertiesIgnoreNull(Object src, Object target) {
		org.springframework.beans.BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static <T> T convertBean(Object src, Class<T> type) {
		T target = null;
		try {
			target = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			Throwables.propagate(e);
		}

		copyPropertiesIgnoreNull(src, target);
		return target;

	}

	/**
	 * 去掉bean中所有属性为字符串的前后空格
	 */
	public static void beanAttributeValueTrim(Object bean) throws Exception {
		if (bean != null) {
			// 获取所有的字段包括public,private,protected,private
			Field[] fields = bean.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				if (f.getType().getName().equals("java.lang.String")) {
					String key = f.getName();// 获取字段名
					Object value = getFieldValue(bean, key);

					if (value == null)
						continue;

					setFieldValue(bean, key, value.toString().trim());
				}
			}
		}
	}

	/**
	 * 利用反射通过get方法获取bean中字段fieldName的值
	 */
	public static Object getFieldValue(Object bean, String fieldName) {
		StringBuffer result = new StringBuffer();
		String methodName = result.append("get").append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1)).toString();

		Object rObject = null;
		Method method = null;

		try {
			@SuppressWarnings("rawtypes")
			Class[] classArr = new Class[0];
			method = bean.getClass().getMethod(methodName, classArr);
			rObject = method.invoke(bean, new Object[0]);
			return rObject;
		} catch (Exception e) {
			Throwables.propagate(e);
			return null;
		}

	}

	/**
	 * 利用发射调用bean.set方法将value设置到字段
	 */
	public static void setFieldValue(Object bean, String fieldName, Object value) {
		StringBuffer result = new StringBuffer();
		String methodName = result.append("set").append(fieldName.substring(0, 1).toUpperCase())
				.append(fieldName.substring(1)).toString();
		try {
			@SuppressWarnings("rawtypes")
			Class[] classArr = new Class[1];
			classArr[0] = "java.lang.String".getClass();
			Method method = bean.getClass().getMethod(methodName, classArr);
			method.invoke(bean, value);
		} catch (Exception e) {
			Throwables.propagate(e);
		}
	}

	public static void rebuildCreateTime(Object bean) {
		try {
			rebuildFieldValueStart(bean, "createTimeStart");
			rebuildFieldValueEnd(bean, "createTimeEnd");
		} catch (Exception e) {
			Throwables.propagate(e);
		}
	}

	public static void rebuildOverTime(Object bean) {
		try {
			rebuildFieldValueStart(bean, "overTimeStart");
			rebuildFieldValueEnd(bean, "overTimeEnd");
		} catch (Exception e) {
			Throwables.propagate(e);
		}
	}

	private static void rebuildFieldValueStart(Object bean, String filedName) throws Exception {
		String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
		Method getMethod = bean.getClass().getMethod(getMethodName, new Class[0]);
		Object value = getMethod.invoke(bean, new Object[0]);
		if (null != value && value instanceof Date) {
			String setMethodName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
			Method setMethod = bean.getClass().getMethod(setMethodName, Date.class);
			setMethod.invoke(bean, DateUtils.dayStart((Date) value));
		}
	}

	private static void rebuildFieldValueEnd(Object bean, String filedName) throws Exception {
		String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
		Method getMethod = bean.getClass().getMethod(getMethodName, new Class[0]);
		Object value = getMethod.invoke(bean, new Object[0]);
		if (null != value && value instanceof Date) {
			String setMethodName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
			Method setMethod = bean.getClass().getMethod(setMethodName, Date.class);
			setMethod.invoke(bean, DateUtils.dayEnd((Date) value));
		}
	}

	public static void initExportPageInfo(Object bean) {
		try {
			String setMethodName1 = "setPageSize";
			Method setMethod1 = bean.getClass().getMethod(setMethodName1, Integer.class);
			setMethod1.invoke(bean, 1000);
			String setMethodName2 = "setPageNum";
			Method setMethod2 = bean.getClass().getMethod(setMethodName2, Integer.class);
			setMethod2.invoke(bean, 1);
		} catch (Exception e) {
			Throwables.propagate(e);
		}
	}

	public static Object deepCloneObject(Object original) {
		Object target = null;
		try {
			if (original != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(original);
				oos.close();
				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bais);
				target = ois.readObject();
				ois.close();
			}
		} catch (Exception e) {
			Throwables.propagate(e);
		}
		return target;
	}

	public static <T> List<T> deepCloneList(List<T> original) {
		List<T> target = null;
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(original);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			target = (List<T>) in.readObject();
		} catch (Exception e) {
			Throwables.propagate(e);
		}
		return target;
	}
}
