package com.adventuroo.fithereum.networking;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by jcailteux on 4/1/16.
 */
public class GsonRequest<T> extends Request<T> {
	private final Class clazz;
	private final Map<String, String> headers;
	private final Response.Listener<T> listener;
	private Gson gson = new Gson();
	private Object payload;

	public GsonRequest(int httpMethod, String url, Class clazz, Map<String, String> headers,
					   Response.Listener<T> listener, Response.ErrorListener errorListener, Integer timeout) {
		super(httpMethod, url, errorListener);
		this.clazz = clazz;
		this.headers = headers;
		this.listener = listener;
		this.setRetryPolicy(new DefaultRetryPolicy(timeout * 1000, 4, 2.0f));
	}

	public void setPayload(Object jsonObject) {
		payload = jsonObject;
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return headers != null ? headers : super.getHeaders();
	}

	@Override
	public byte[] getBody() {
		if (payload == null)
			return null;
		return gson.toJson(payload).getBytes(Charset.forName("UTF-8"));
	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String json = new String(
					response.data, HttpHeaderParser.parseCharset(response.headers));
			return Response.success(
					(T) gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}
}
