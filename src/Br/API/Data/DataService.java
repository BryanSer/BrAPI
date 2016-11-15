/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Data;

import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface DataService {

    public String getPluginName();

    public Object get(String path);

    public boolean contains(String path);

    public boolean containsType(String path, Class<?> c);

    public void set(String path, Object o);
    
    public Set<String> getKeySet();
}
