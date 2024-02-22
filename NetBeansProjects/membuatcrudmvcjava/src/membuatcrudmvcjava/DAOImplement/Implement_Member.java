/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membuatcrudmvcjava.DAOImplement;

import java.util.List;
import membuatcrudmvcjava.Model.Model_Member;

/**
 *
 * @author Administrator
 */
public interface Implement_Member {
    
    public void insert(Model_Member b);
    
    public void update(Model_Member b);
    
    public void delete(int id);
    
    public List<Model_Member> getALL();
    
    public List<Model_Member> getCariNama(String nama);
}
