package com.example.ssotest.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieUtils
{
  private static String default_path = "/";
  
  public static void addCookie(HttpServletResponse response, String name, String value, int age)
  {
    Cookie cookies = new Cookie(name, value);
    cookies.setPath("/");
    cookies.setMaxAge(age);
    response.addCookie(cookies);
  }
  
  public static void addCookie(HttpServletResponse response, String name, String value, int age, String url)
  {
    Cookie cookies = new Cookie(name, value);
    cookies.setPath("/");
    cookies.setDomain(url);
    cookies.setMaxAge(age);
    response.addCookie(cookies);
  }
  
  public static String getCookieValue(HttpServletRequest request, String cookieName)
  {
    if (cookieName != null)
    {
      Cookie cookie = getCookie(request, cookieName);
      if (cookie != null) {
        return cookie.getValue();
      }
    }
    return "";
  }
  
  public static Cookie getCookie(HttpServletRequest request, String cookieName)
  {
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    try
    {
      if ((cookies != null) && (cookies.length > 0))
      {
        Cookie tmpCookie = null;
        for (int i = 0; i < cookies.length; i++)
        {
          tmpCookie = cookies[i];
          if (tmpCookie.getName().equals(cookieName)) {
            cookie = tmpCookie;
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return cookie;
  }
  
  public static boolean deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName)
  {
    if (cookieName != null)
    {
      Cookie cookie = getCookie(request, cookieName);
      if (cookie != null)
      {
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setValue("");
        response.addCookie(cookie);
        return true;
      }
    }
    return false;
  }
  
  public static void delCookie(HttpServletResponse httpservletresponse, HttpServletRequest httpservletrequest, String s)
    throws UnsupportedEncodingException
  {
    Cookie[] acookie = httpservletrequest.getCookies();
    if (acookie != null) {
      for (int i = 0; i < acookie.length; i++)
      {
        String s1 = acookie[i].getName();
        if (s1.equals(s))
        {
          acookie[i].setMaxAge(0);
          httpservletresponse.addCookie(acookie[i]);
        }
      }
    }
  }
  
  public static void addCookie(String name, String value, HttpServletResponse response, int age)
    throws Exception
  {
    Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
    cookie.setPath(default_path);
    cookie.setMaxAge(age);
    response.addCookie(cookie);
  }
  
  public static String findCookie(String name, HttpServletRequest request)
    throws UnsupportedEncodingException
  {
    String value = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++)
      {
        Cookie curr = cookies[i];
        if (curr.getName().equals(name)) {
          value = URLDecoder.decode(curr.getValue(), "utf-8");
        }
      }
    }
    return value;
  }
  
  public static void deleteCookie(String name, HttpServletResponse response, String domain)
  {
    Cookie cookie = new Cookie(name, null);
    cookie.setMaxAge(-1);
    cookie.setDomain(domain);
    cookie.setPath(default_path);
    response.addCookie(cookie);
  }
}
