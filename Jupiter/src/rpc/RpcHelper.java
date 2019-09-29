package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class RpcHelper {
	//write a JSONArray to http response
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
		response.setContentType("application/json");
		//allow all cross-origin resource sharing
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(array);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//write a JSONObj to http response
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(obj);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//parse a JSONObject from http request
	public static JSONObject readJSONObject(HttpServletRequest request) {
		StringBuilder sBuilder = new StringBuilder();
		try(BufferedReader reader = request.getReader()) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				sBuilder.append(line);
			}
			return new JSONObject(sBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return new JSONObject();
	}
}
