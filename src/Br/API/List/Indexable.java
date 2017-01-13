/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.List;

/**
 *
 * @author Administrator
 */
public interface Indexable {

    /**
     * 不得出现重复的序号~.
     * 也不得出现负值
     * @return
     */
    public int getIndex();
}
