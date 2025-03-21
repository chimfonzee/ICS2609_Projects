/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webappjdbc.utils;

import java.util.HashMap;

/**
 *
 * @author fonze
 */
public final class DatabaseConstants {
    public static final HashMap<String, String> STATEMENTS = new HashMap<String, String>() {{
        put("getUser", "select * from users where username = ?");
    }};
}
