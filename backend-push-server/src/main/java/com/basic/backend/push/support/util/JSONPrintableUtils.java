package com.basic.backend.push.support.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import lombok.extern.slf4j.Slf4j;

/**
 * JSON打印工具类
 * 
 * @author Field
 */
@Slf4j
public class JSONPrintableUtils {

	/**
	 * 模拟请求JSON String
	 */
	public static String mockRequestJSON(Object req) {
		return JSONObject.toJSONString(req, SerializerFeature.WriteMapNullValue);
	}

	/**
	 * 模拟请求JSON String
	 */
	public static String mockRequestJSON(Object... objects) {
		Map<String, Object> model = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		for (Object o : objects) {
			data.put(getResName(o), o);
		}
		model.put("data", data);
		return JSONObject.toJSONString(model, SerializerFeature.WriteMapNullValue);
	}

	/**
	 * 模拟响应JSON String
	 */
	public static String mockResponseJSON(Object... objects) {
		Map<String, Object> model = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		for (Object o : objects) {
			data.put(getResName(o), o);
		}
		model.put("data", data);
		return JSONObject.toJSONString(model, SerializerFeature.WriteMapNullValue);
	}

	/**
	 * 模拟响应JSON String
	 */
	public static String mockResponseSimpleJSON(Object objects) {
		Map<String, Object> model = new HashMap<>();
		model.put("data", objects);
		return JSONObject.toJSONString(model, SerializerFeature.WriteMapNullValue);
	}

	private static String getResName(Object obj) {
		String name = obj.getClass().getSimpleName();
		String nameFull = obj.getClass().getName();
		System.out.println(nameFull);
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		return name;
	}

	public static void main(String args[]) {
//		QueryBaseRes<RoleUserDTO> data = new QueryBaseRes<>();
//		RoleUserDTO dto = new RoleUserDTO();
//		data.getResultList().add(dto);
//		log.info(">>>>>>:{}", mockResponseSimpleJSON(data));
//		Notice r = new Notice();
//		List l = new ArrayList();
//		l.add(r);
		//log.info(">>>>>>:{}", mockRequestJSON(r));
//		log.info(">>>>>>:{}", mockResponseSimpleJSON(r));
	}
}
